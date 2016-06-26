package org.itstep.prokopchik.cricova.database.dao.wine;

import org.itstep.prokopchik.cricova.*;

abstract public class DAOWine {

    abstract public Wine createWine(String name,
                                    Integer price,
                                    Integer ndsRate,
                                    Object image,
                                    String annotation,
                                    WineTypeEnum wineType,
                                    WineColorEnum wineColor,
                                    WineAgeEnum wineAge,
                                    WineSugarContentEnum wineSugarContent,
                                    WineSpiritContentEnum wineSpiritContent,
                                    WineCollectionEnum wineCollection
    );

    abstract public Wine createWine(Wine wine);

    abstract public Wine getWine(String name);

    abstract public Wine getWineById(Integer id);
}
