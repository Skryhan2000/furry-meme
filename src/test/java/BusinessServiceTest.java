import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.entity.Index;
import com.loneliness.server.controller.CommandName;
import com.loneliness.server.controller.CommandProvider;
import com.loneliness.server.controller.ControllerException;
import com.loneliness.server.servise.ServiceException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BusinessServiceTest {
    private Index validIndex = new Index();
    private Index invalid=new Index();
    private CommandProvider commandProvider;
    private DifferentialIndicators validDifferentialIndicators=new DifferentialIndicators();


    {
        validIndex.setNetProfit(new BigDecimal("78096"));
        validIndex.setRevenuesFromSales(new BigDecimal("296809"));
        validIndex.setAssets(new BigDecimal("672421"));
        validIndex.setEquity(new BigDecimal("478853"));
        validIndex.setAttractedCapital(new BigDecimal("193568"));
        commandProvider = CommandProvider.getCommandProvider();
        invalid.setRevenuesFromSales(new BigDecimal("0"));
        invalid.setAssets(new BigDecimal("0"));
        invalid.setEquity(new BigDecimal("0"));
        validDifferentialIndicators.setProfitability(new BigDecimal("26.3"));
        validDifferentialIndicators.setNetAssetTurnover(new BigDecimal("0.44"));
        validDifferentialIndicators.setRONA(new BigDecimal("16.6"));
        validDifferentialIndicators.setFL(new BigDecimal("11.4"));


    }


    @Test
    public void calculateProfitabilityValidTest() throws ControllerException {
        BigDecimal expectedResult = new BigDecimal("26.3");
        Assert.assertEquals(expectedResult, commandProvider.getCommand(CommandName.CALCULATE_PROFITABILITY).
                execute(validIndex));
    }

    @Test( expected =  ControllerException .class )
    public void calculateProfitabilityInvalidTest() throws  ControllerException {

        commandProvider.getCommand(CommandName.CALCULATE_PROFITABILITY).execute(invalid);
    }

    @Test
    public void calculateValidNetAssetTurnover() throws ControllerException {
        BigDecimal expectedResult = new BigDecimal("0.44");
        Assert.assertEquals(expectedResult, commandProvider.getCommand(CommandName.CALCULATE_NET_ASSET_TURNOVER).
                execute(validIndex));
    }

    @Test( expected = ControllerException.class )
    public void calculateInvalidNetAssetTurnover() throws  ControllerException {
        Index index =new Index();
       commandProvider.getCommand(CommandName.CALCULATE_NET_ASSET_TURNOVER).execute(invalid);
    }

    @Test
    public void calculateValidRONA() throws ControllerException {
        BigDecimal expectedResult = new BigDecimal("11.6");
        Assert.assertEquals(expectedResult, commandProvider.getCommand(CommandName.CALCULATE_RONA).
                execute(validIndex));
    }

    @Test( expected =  ControllerException .class )
    public void calculateInvalidRONA() throws ServiceException, ControllerException {
        commandProvider.getCommand(CommandName.CALCULATE_RONA).execute(invalid);
    }

    @Test
    public void calculateValidFL() throws ControllerException {
        BigDecimal expectedResult = new BigDecimal("1.4");
        Assert.assertEquals(expectedResult, commandProvider.getCommand(CommandName.CALCULATE_FL).
                execute(validIndex));
    }

    @Test( expected =  ControllerException .class )
    public void calculateInvalidFL() throws ControllerException {
        commandProvider.getCommand(CommandName.CALCULATE_FL).execute(invalid);
    }
    @Test public void calculateROE() throws ControllerException {
        BigDecimal expectedResult = new BigDecimal("16.2");
        Assert.assertEquals(expectedResult, commandProvider.getCommand(CommandName.CALCULATE_ROE).
                execute(validIndex));
    }
    @Test( expected =  ControllerException .class )
    public void calculateInvalidROE() throws ControllerException {
        commandProvider.getCommand(CommandName.CALCULATE_ROE).execute(invalid);
    }
    @Test public void calculateAllDifferentialIndicators() throws ControllerException {
        // TODO: 23.11.2019 дописать
        Assert.assertEquals(validDifferentialIndicators,CommandProvider.getCommandProvider().
                getCommand(CommandName.CALCULATE_ALL_DIFFERENTIAL_INDICATORS).execute(invalid));

    }
}
