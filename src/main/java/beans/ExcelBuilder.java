package beans;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

@Component
public class ExcelBuilder extends AbstractExcelView {

	@Autowired
	MessageSource messageSource;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// get data model which is passed by the Spring container
        List<Curso> cursos = (List<Curso>) model.get("cursos");
        String source =  (String) model.get("source");
        String titulo=""; 
        if("alumno".equals(source)) {
        	titulo="Lista de cursos matriculados";
        }else {
        	titulo="Lista de cursos impartidos";
        }
        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet(titulo);
        sheet.setDefaultColumnWidth(30);
         
        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
         
        // create header row
        
        HSSFRow title= sheet.createRow(0);
        
        title.createCell(0).setCellValue(titulo);
        HSSFRow header = sheet.createRow(2);
        
        
         
        header.createCell(0).setCellValue("ID");
        header.getCell(0).setCellStyle(style);
         
        header.createCell(1).setCellValue("Nombre");
        header.getCell(1).setCellStyle(style);
         
        header.createCell(2).setCellValue("Descripcion");
        header.getCell(2).setCellStyle(style);
         
        header.createCell(3).setCellValue("Precio");
        header.getCell(3).setCellStyle(style);
         
        header.createCell(4).setCellValue("Instructor");
        header.getCell(4).setCellStyle(style);
         
        // create data rows
        int rowCount = 1;
         
        for (Curso c : cursos) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(c.getId_curso());
            aRow.createCell(1).setCellValue(c.getNombre());
            aRow.createCell(2).setCellValue(c.getDescripcion());
            aRow.createCell(3).setCellValue(c.getPrecio());
            if(c.getInstructor()!=null) {
            	aRow.createCell(4).setCellValue(c.getInstructor().getNombre());
            }
        }
    }
	

}
