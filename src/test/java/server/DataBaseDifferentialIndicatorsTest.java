package server;

import com.github.javafaker.Faker;
import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.server.controller.CommandName;
import com.loneliness.server.controller.CommandProvider;
import com.loneliness.server.controller.ControllerException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public class DataBaseDifferentialIndicatorsTest {
    private Faker faker=new Faker();
    private static DifferentialIndicators valid=new DifferentialIndicators();
    private static DifferentialIndicators invalid=new DifferentialIndicators();
    @BeforeClass public static void addDifferentialIndicators(){
        valid.setCompanyName("valid");
        valid.setReportingPeriod(LocalDate.now());
        valid.setProfR(new BigDecimal("10"));
        valid.setNetA(new BigDecimal("10"));
        valid.setRONA(new BigDecimal("12"));
        valid.setFL(new BigDecimal("10"));
        valid.setROE(new BigDecimal("10"));
        valid.setSG(new BigDecimal("10"));
        valid.setWACC(new BigDecimal("10"));

        invalid.setCompanyName("invalid");
        invalid.setReportingPeriod(LocalDate.now());
        invalid.setProfR(new BigDecimal("10"));
        invalid.setNetA(new BigDecimal("10"));
        invalid.setRONA(new BigDecimal("12"));
        invalid.setFL(new BigDecimal("10"));
        invalid.setROE(new BigDecimal("10"));
        invalid.setSG(new BigDecimal("10"));
        invalid.setWACC(new BigDecimal("10"));

    }
    private DifferentialIndicators changeData(DifferentialIndicators data){
        data.setCompanyName(faker.company().name());
        data.setReportingPeriod(LocalDate.now());
        data.setProfR(new BigDecimal(faker.number().randomDigit()));
        data.setNetA(new BigDecimal(faker.number().randomDigit()));
        data.setRONA(new BigDecimal(faker.number().randomDigit()));
        data.setFL(new BigDecimal(faker.number().randomDigit()));
        data.setROE(new BigDecimal(faker.number().randomDigit()));
        data.setSG(new BigDecimal(faker.number().randomDigit()));
        data.setWACC(new BigDecimal(faker.number().randomDigit()));
        return data;
    }

    @Test public void addDataBaseDifferentialIndicatorsTest() throws ControllerException {
        Assert.assertEquals("Данные успешно добавлены", CommandProvider.getCommandProvider().
                getCommand(CommandName.CREATE_DIFFERENTIAL_INDICATORS).execute(changeData(valid)));
    }
    @Test public void updateDataBaseDifferentialIndicatorsTest() throws ControllerException {
        int[] bound={0,1};
        Map<Integer, DifferentialIndicators> dataMap=(Map<Integer, DifferentialIndicators>) CommandProvider.getCommandProvider().
                getCommand(CommandName.RECEIVE_ALL_DIFFERENTIAL_INDICATORS_IN_LIMIT).execute(bound);
        Assert.assertEquals("Данные обновлены", CommandProvider.getCommandProvider().
                getCommand(CommandName.UPDATE_DIFFERENTIAL_INDICATORS).execute(dataMap.values().iterator().next()));
    }
    @Test public void deleteValidDifferentialIndicators() throws ControllerException {
        int[] bound={0,1};
        Map<Integer, DifferentialIndicators> dataMap=(Map<Integer, DifferentialIndicators>) CommandProvider.getCommandProvider().
                getCommand(CommandName.RECEIVE_ALL_DIFFERENTIAL_INDICATORS_IN_LIMIT).execute(bound);
        Assert.assertEquals("Данные удалены", CommandProvider.getCommandProvider().
                getCommand(CommandName.DELETE_DIFFERENTIAL_INDICATORS).execute(dataMap.values().iterator().next()));
    }

}
