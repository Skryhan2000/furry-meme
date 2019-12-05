package com.loneliness.client.service.service_impl;

import com.loneliness.client.dao.DAOException;
import com.loneliness.client.service.FactoryService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.client.view.PathManager;
import com.loneliness.entity.Report;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
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
    private static final ReportService instance = new ReportService();
    private final ROEService roeService= FactoryService.getInstance().getRoeService();
    private ReportService() {
    }

    public static ReportService getInstance() {
        return instance;
    }

    private String REPORT_pdf;
    private String REPORT_pattern;

    public String create(Report report) throws  ServiceException {
        switch (report) {
            case ROE:
                REPORT_pattern = "Report\\QuarterReport.jrxml";
                REPORT_pdf = "Report\\ROEReport.pdf";
                break;
        }
        try {
        // Параметры
        Map<String, Object> parameters;
        parameters = new HashMap<String, Object>();
        parameters.put("DATE", new Date());
        Locale.setDefault(new Locale("ru", "RU"));
        parameters.put(JRParameter.REPORT_LOCALE, new Locale("ru", "RU"));
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(roeService.receiveAllElem().values());
        File reportPattern = new File( REPORT_pattern);
        JasperDesign jasperDesign = null;

            jasperDesign = JRXmlLoader.load(reportPattern);

        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                parameters, beanColDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, REPORT_pdf);
        return "Отчёт успешно создан ";
    } catch (JRException e) {
        throw new ServiceException("Ошибка создание отчета по ROE ", e.getMessage());
    }
    }
}
