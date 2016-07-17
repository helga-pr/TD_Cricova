package org.itstep.prokopchik.cricova.database.dao.article;

import org.itstep.prokopchik.cricova.Article;

import java.util.List;

interface DAOArticle {

    Article createArticle(String name,
                          String content,
                          Object image);

    Article createArticle(Article article);

    Article findArticle(String name);

    Article findArticleById(Integer id);

    List<Article> findAllArticles(Integer id);

}
