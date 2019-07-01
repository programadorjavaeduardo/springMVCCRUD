package view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import beans.Persona;
import service.PersonaService;

@Component
public class PdfView extends AbstractPdfView {

	
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Persona> personList = (List<Persona>) model.get("personas");

        PdfPTable table = new PdfPTable(5);

        table.addCell("ID");
        table.addCell("Name");
        table.addCell("Father surname");
        table.addCell("Mother surname");
        table.addCell("Email");

        for(Persona p: personList) {
            table.addCell(p.getId_persona().toString());
            table.addCell(p.getNombre());
            table.addCell(p.getApe_paterno());
            table.addCell(p.getApe_materno());
            table.addCell(p.getEmail());
        }

        document.add(table);
    }


	

}