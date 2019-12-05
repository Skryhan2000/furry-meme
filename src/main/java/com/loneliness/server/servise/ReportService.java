package com.loneliness.server.servise;

import com.loneliness.entity.Report;
import com.loneliness.server.dao.DataBaseConnection;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ReportService {
    private final String REPORT_pdf     = "Report\\ROEReport.pdf";
    private final String REPORT_pattern = "Report\\QuarterReport.jrxml";

    public void create() throws ServiceException {
        // Параметры
        Map<String, Object> parameters;
        parameters = new HashMap<String, Object>();
        parameters.put("DATE", new Date());
        Locale.setDefault(new Locale("ru", "RU"));
        parameters.put(JRParameter.REPORT_LOCALE, new Locale("ru", "RU"));
        try(Connection connection=DataBaseConnection.getInstance().getConnection()) {

            JasperDesign jasperDesign;
            JasperReport jasperReport;
            JasperPrint jasperPrint;

            String path = REPORT_pattern;
            File reportPattern = new File(path);

            jasperDesign = JRXmlLoader.load(reportPattern);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport,
                    parameters,
                    connection);
            path = REPORT_pdf;
            JasperExportManager.exportReportToPdfFile(jasperPrint, path);
          //  return true;
        } catch (SQLException | PropertyVetoException | JRException e) {
           throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Начало генерации отчёта");
        try {
            new ReportService().create();
            System.out.println("Генерация отчёта завершена");
        } catch (Exception | ServiceException e) {
            System.err.println("Во время генерации возникла ошибка: " + e);
        }
    }
}
