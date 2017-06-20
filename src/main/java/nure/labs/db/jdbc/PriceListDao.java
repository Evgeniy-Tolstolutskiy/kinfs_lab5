package nure.labs.db.jdbc;

import nure.labs.db.model.PriceListItem;

import java.util.List;

/**
 * Created by Евгений on 23.12.2016.
 */
public interface PriceListDao {
    PriceListItem selectPriceListByAircraftId(int aircraftId);

    List<PriceListItem> selectPriceList();

    boolean insertPriceListItem(PriceListItem priceListItem);

    boolean updatePriceListItem(int oldId, PriceListItem priceListItem);

    boolean deletePriceListItem(int id);
}
