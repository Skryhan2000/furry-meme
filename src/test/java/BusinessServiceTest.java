import com.loneliness.entity.Index;
import com.loneliness.server.controller.CommandName;
import com.loneliness.server.controller.CommandProvider;
import com.loneliness.server.servise.ServiceException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BusinessServiceTest {
    private Index index = new Index();
    private Index invalid=new Index();
    private CommandProvider commandProvider;

    {
        index.setNetProfit(new BigDecimal("78096"));
        index.setRevenuesFromSales(new BigDecimal("296809"));
        index.setAssets(new BigDecimal("672421"));
        index.setEquity(new BigDecimal("478853"));
        index.setAttractedCapital(new BigDecimal("193568"));
        commandProvider = CommandProvider.getCommandProvider();
        invalid.setRevenuesFromSales(new BigDecimal("0"));
        invalid.setAssets(new BigDecimal("0"));
        invalid.setEquity(new BigDecimal("0"));

    }


    @Test
    public void calculateProfitabilityValidTest() {
        BigDecimal expectedResult = new BigDecimal("26.3");
        Assert.assertEquals(expectedResult, commandProvider.getCommand(CommandName.CALCULATE_PROFITABILITY).
                execute(index));
    }

    @Test( expected = ServiceException.class )
    public void calculateProfitabilityInvalidTest() throws ServiceException {

        commandProvider.getCommand(CommandName.CALCULATE_PROFITABILITY).execute(invalid);
    }

    @Test
    public void calculateValidNetAssetTurnover() {
        BigDecimal expectedResult = new BigDecimal("0.44");
        Assert.assertEquals(expectedResult, commandProvider.getCommand(CommandName.CALCULATE_NET_ASSET_TURNOVER).
                execute(index));
    }

    @Test( expected = ServiceException.class )
    public void calculateInvalidNetAssetTurnover() throws ServiceException{
        Index index =new Index();
       commandProvider.getCommand(CommandName.CALCULATE_NET_ASSET_TURNOVER).execute(invalid);
    }

    @Test
    public void calculateValidRONA() {
        BigDecimal expectedResult = new BigDecimal("11.6");
        Assert.assertEquals(expectedResult, commandProvider.getCommand(CommandName.CALCULATE_RONA).
                execute(index));
    }

    @Test( expected = ServiceException.class )
    public void calculateInvalidRONA() throws ServiceException{
        commandProvider.getCommand(CommandName.CALCULATE_RONA).execute(invalid);
    }

    @Test
    public void calculateValidFL() {
        BigDecimal expectedResult = new BigDecimal("1.4");
        Assert.assertEquals(expectedResult, commandProvider.getCommand(CommandName.CALCULATE_FL).
                execute(index));
    }

    @Test( expected = ServiceException.class )
    public void calculateInvalidFL() {
        commandProvider.getCommand(CommandName.CALCULATE_FL).execute(invalid);
    }
}
