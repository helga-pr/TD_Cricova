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

    /**
     * @param id
     * @return количество удаленных строк
     */
    Integer deleteWineById(Integer id);

    List<Wine> findAllWines();

    List<Wine> findWineByName(String name);

    List<Wine> findWineByWineType(String wineType);

    List<Wine> findWineByWineColor(String wineColor);

    List<Wine> findWineByWineAge(String wineAge);

    List<Wine> findWineByWineSugarContent(String wineSugarContent);

    List<Wine> findWineByWineSpiritContent(String wineSpiritContent);

    List<Wine> findWineByWineCollection(String wineCollection);

    List<Wine> findWineByCriteria(WineTypeEnum wineType,
                                  WineAgeEnum wineAge,
                                  WineColorEnum wineColor,
                                  WineSugarContentEnum wineSugarContent,
                                  WineSpiritContentEnum wineSpiritContent,
                                  WineCollectionEnum wineCollection);

}
