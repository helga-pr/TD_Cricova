package org.itstep.prokopchik.cricova.database.dao.article;

import org.itstep.prokopchik.cricova.Article;

abstract public class DAOArticle {

    abstract public Article createArticle(String name,
                                          String content,
                                          Object image);

    abstract public Article getArticle(String name);

    abstract public Article getArticleById(Integer id);
}
