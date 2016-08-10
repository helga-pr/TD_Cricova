package org.itstep.prokopchik.cricova.database.dao.wine;

import org.itstep.prokopchik.cricova.*;

import java.util.List;

interface DAOWine {

    Wine createWine(String name,
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

    Wine createWine(Wine wine);

    Wine findWineById(Integer id);

    List<Wine> findAllWines();

    List<Wine> findWineByName(String name);

    List<Wine> findWineByWineType(WineTypeEnum wineType);

    List<Wine> findWineByWineColor(WineColorEnum wineColor);

    List<Wine> findWineByWineAge(WineAgeEnum wineAge);

    List<Wine> findWineByWineSugarContent(WineSugarContentEnum wineSugarContent);

    List<Wine> findWineByWineSpiritContent(WineSpiritContentEnum wineSpiritContent);

    List<Wine> findWineByWineCollection(WineCollectionEnum wineCollection);

}
