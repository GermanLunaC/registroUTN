package com.app.web.reporte;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.app.web.entidad.Estudiante;

public class EstudianteExporter {
	
	private XSSFWorkbook libro;
	private XSSFSheet hoja;
	
	private List<Estudiante> listaEstudiantes;

	public EstudianteExporter(List<Estudiante> listaEmpleados) {
		this.listaEstudiantes = listaEmpleados;
		libro=new XSSFWorkbook();
		hoja=libro.createSheet("Estudiante");
	}
	
	private void escribirCabeceraDeTabla() {
		Row fila=hoja.createRow(0);
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(10);
		estilo.setFont(fuente);
		
		Cell celda = fila.createCell(0);
		celda.setCellValue("ID");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(1);
		celda.setCellValue("Nombre");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(2);
		celda.setCellValue("Matricula");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(3);
		celda.setCellValue("Carrera");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(4);
		celda.setCellValue("Grupo");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(5);
		celda.setCellValue("Actividad");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(6);
		celda.setCellValue("Aprobado");
		celda.setCellStyle(estilo);
	}
	
	private void escribirDatosDeLaTabla() {
		int numeroFilas = 1;
		
		CellStyle estilo=libro.createCellStyle();
		XSSFFont fuente=libro.createFont();
		fuente.setFontHeight(10);
		estilo.setFont(fuente);
		
		for(Estudiante estudiante : listaEstudiantes) {
			Row fila = hoja.createRow(numeroFilas ++);
			
			Cell celda=fila.createCell(0);
			celda.setCellValue(estudiante.getId());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);
			
			celda=fila.createCell(1);
			celda.setCellValue(estudiante.getNombre());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			
			celda=fila.createCell(2);
			celda.setCellValue(estudiante.getMatricula());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);
			
			celda=fila.createCell(3);
			celda.setCellValue(estudiante.getCarrera());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);
			
			celda=fila.createCell(4);
			celda.setCellValue(estudiante.getGrupo());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);
			
			celda=fila.createCell(5);
			celda.setCellValue(estudiante.getActividad());
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);
			
			celda=fila.createCell(6);
			celda.setCellValue(estudiante.getSituacion());
			hoja.autoSizeColumn(6);
			celda.setCellStyle(estilo);
			
		}
	}
	
	public void exportar(HttpServletResponse response) throws IOException {
		escribirCabeceraDeTabla();
		escribirDatosDeLaTabla();
		
		ServletOutputStream outPutStream = response.getOutputStream();
		libro.write(outPutStream);
		
		libro.close();
		outPutStream.close();
		}
	
}
