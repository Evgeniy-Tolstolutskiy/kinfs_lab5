package nure.labs.db.jdbc.impl;

import nure.labs.db.jdbc.PriceListDao;
import nure.labs.db.model.PriceListItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Евгений on 23.12.2016.
 */
@Component
public class PriceListDaoImpl extends JdbcDao implements PriceListDao {
    @Override
    public PriceListItem selectPriceListByAircraftId(int aircraftId) {
        String sql = "select * from PriceList where aircraftId=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{aircraftId}, (rs, rowNum) -> {
            int id = rs.getInt("id");
            double classACost = rs.getDouble("classA");
            double classBCost = rs.getDouble("classB");
            double classCCost = rs.getDouble("classC");
            return new PriceListItem(id, aircraftId, classACost, classBCost, classCCost);
        });
    }

    @Override
    public List<PriceListItem> selectPriceList() {
        List<PriceListItem> priceListItems = new ArrayList<>();
        String sql = "select * from PriceList";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            int id = ((java.math.BigDecimal) row.get("id")).intValue();
            int aircraftId = ((java.math.BigDecimal) row.get("aircraftId")).intValue();
            double classAPrice = (double) row.get("classA");
            double classBPrice = (double) row.get("classB");
            double classCPrice = (double) row.get("classC");
            priceListItems.add(new PriceListItem(id, aircraftId, classAPrice, classBPrice, classCPrice));
        }
        return priceListItems;
    }

    @Override
    public boolean insertPriceListItem(PriceListItem priceListItem) {
        String sql = "call insert_pricelist(?, ?, ?, ?)";
        jdbcTemplate.update(sql, priceListItem.getAircraftId(), priceListItem.getClassAPrice(),
                priceListItem.getClassBPrice(), priceListItem.getClassCPrice());
        return true;
    }

    @Override
    public boolean updatePriceListItem(int oldId, PriceListItem priceListItem) {
        String sql = "update PriceList set id=?, aircraftId=?, classA=?, classB=?, classC=? where id=?";
        jdbcTemplate.update(sql, priceListItem.getId(), priceListItem.getAircraftId(), priceListItem.getClassAPrice(),
                priceListItem.getClassBPrice(), priceListItem.getClassCPrice(), oldId);
        return true;
    }

    @Override
    public boolean deletePriceListItem(int id) {
        String sql = "delete from PriceList where id=?";
        jdbcTemplate.update(sql, id);
        return true;
    }
}
