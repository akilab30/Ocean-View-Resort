package com.oceanview.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.oceanview.model.Reservation;

@WebServlet("/bill-pdf")
public class BillPdfServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        Reservation bill = (Reservation) req.getSession().getAttribute("bill");

        if (bill == null) {
            res.sendRedirect("dashboard.jsp");
            return;
        }

        try {
            res.setContentType("application/pdf");

            String fileName = "bill";
            try {
                if (bill.getId() > 0) {
                    fileName = "bill-" + bill.getId();
                }
            } catch (Exception ignore) {}
            res.setHeader(
                "Content-Disposition",
                "attachment; filename=" + fileName + ".pdf"
            );

            // Page setup
            Rectangle pageSize = PageSize.A4;
            Document document = new Document(pageSize, 50f, 50f, 60f, 50f);
            PdfWriter.getInstance(document, res.getOutputStream());
            document.open();

            // Fonts
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.BLACK);
            Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 11, BaseColor.DARK_GRAY);
            Font sectionTitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13, BaseColor.BLACK);
            Font labelFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, new BaseColor(70, 70, 70));
            Font valueFont = FontFactory.getFont(FontFactory.HELVETICA, 11, BaseColor.BLACK);
            Font totalFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.WHITE);

            // Header with resort name (no logo per spec)
            PdfPTable header = new PdfPTable(1);
            header.setWidthPercentage(100);

            PdfPCell titleCell = new PdfPCell();
            titleCell.setBorder(Rectangle.NO_BORDER);
            Paragraph title = new Paragraph("Ocean View Resort", titleFont);
            title.setAlignment(Element.ALIGN_LEFT);
            Paragraph tagline = new Paragraph("Where comfort meets the ocean breeze", subtitleFont);
            tagline.setSpacingBefore(4);
            titleCell.addElement(title);
            titleCell.addElement(tagline);
            header.addCell(titleCell);

            document.add(header);

            LineSeparator ls = new LineSeparator();
            ls.setLineColor(new BaseColor(200, 200, 200));
            document.add(new Chunk(ls));

            // Issue date/time
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy 'at' HH:mm");
            Paragraph issued = new Paragraph("Issued: " + sdf.format(new Date()), valueFont);
            issued.setSpacingBefore(6);
            issued.setSpacingAfter(10);
            document.add(issued);

            // Bill title
            Paragraph billTitle = new Paragraph("Final Bill", sectionTitleFont);
            billTitle.setAlignment(Element.ALIGN_CENTER);
            billTitle.setSpacingBefore(5);
            billTitle.setSpacingAfter(12);
            document.add(billTitle);

            // Details table
            PdfPTable details = new PdfPTable(2);
            details.setWidthPercentage(100);
            details.setWidths(new float[] { 2.2f, 4.2f });

            addRow(details, "Reservation ID", String.valueOf(bill.getId()), labelFont, valueFont);
            addRow(details, "Guest Name", nvl(bill.getGuestName()), labelFont, valueFont);
            addRow(details, "Room Type", nvl(bill.getRoomType()), labelFont, valueFont);
            addRow(details, "Nights", String.valueOf(bill.getNights()), labelFont, valueFont);
            

            SimpleDateFormat ddf = new SimpleDateFormat("MMM dd, yyyy");
            try { addRow(details, "Check-in", bill.getCheckIn() != null ? ddf.format(bill.getCheckIn()) : "-", labelFont, valueFont); } catch (Exception e) { addRow(details, "Check-in", "-", labelFont, valueFont); }
            try { addRow(details, "Check-out", bill.getCheckOut() != null ? ddf.format(bill.getCheckOut()) : "-", labelFont, valueFont); } catch (Exception e) { addRow(details, "Check-out", "-", labelFont, valueFont); }

            
            addRow(details, "Email", String.valueOf(bill.getEmail()), labelFont, valueFont);
            addRow(details, "Contact No.", String.valueOf(bill.getContact()), labelFont, valueFont);
            details.setSpacingAfter(14);
            document.add(details);

            // Total section
            PdfPTable totalTable = new PdfPTable(2);
            totalTable.setWidthPercentage(60);
            totalTable.setWidths(new float[] { 2.5f, 2.5f });
            totalTable.setHorizontalAlignment(Element.ALIGN_RIGHT);

            PdfPCell totalLabel = new PdfPCell(new Phrase("TOTAL (LKR)", totalFont));
            totalLabel.setBackgroundColor(new BaseColor(60, 60, 60));
            totalLabel.setHorizontalAlignment(Element.ALIGN_CENTER);
            totalLabel.setVerticalAlignment(Element.ALIGN_MIDDLE);
            totalLabel.setPaddingTop(8);
            totalLabel.setPaddingBottom(8);
            totalLabel.setPaddingLeft(6);
            totalLabel.setPaddingRight(6);
            totalLabel.setBorderColor(new BaseColor(60, 60, 60));

            DecimalFormat money = new DecimalFormat("#,##0.00");
            PdfPCell totalValue = new PdfPCell(new Phrase(money.format(bill.getTotalAmount()), totalFont));
            totalValue.setBackgroundColor(new BaseColor(30, 30, 30));
            totalValue.setHorizontalAlignment(Element.ALIGN_CENTER);
            totalValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
            totalValue.setPaddingTop(8);
            totalValue.setPaddingBottom(8);
            totalValue.setPaddingLeft(6);
            totalValue.setPaddingRight(6);
            totalValue.setBorderColor(new BaseColor(30, 30, 30));

            totalTable.addCell(totalLabel);
            totalTable.addCell(totalValue);
            totalTable.setSpacingAfter(20);
            document.add(totalTable);

            // Footer note
            Paragraph thanks = new Paragraph("Thank you for choosing Ocean View Resort.", valueFont);
            thanks.setAlignment(Element.ALIGN_CENTER);
            thanks.setSpacingBefore(20);
            document.add(thanks);

            Paragraph contact = new Paragraph("Contact: +94 11 0000 000 | info@oceanviewresort.lk", subtitleFont);
            contact.setAlignment(Element.ALIGN_CENTER);
            contact.setSpacingBefore(6);
            document.add(contact);

            document.close();

        } catch (DocumentException de) {
            throw new IOException(de);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addRow(PdfPTable table, String label, String value, Font labelFont, Font valueFont) {
        PdfPCell l = new PdfPCell(new Phrase(label, labelFont));
        l.setBackgroundColor(new BaseColor(245, 245, 245));
        l.setBorderColor(new BaseColor(230, 230, 230));
        l.setPadding(8);
        table.addCell(l);

        PdfPCell v = new PdfPCell(new Phrase(value, valueFont));
        v.setBorderColor(new BaseColor(230, 230, 230));
        v.setPadding(8);
        table.addCell(v);
    }

    private static String nvl(String s) {
        return s == null ? "-" : s;
    }
}