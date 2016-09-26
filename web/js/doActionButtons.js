/**
 * Скрипты из этого файла могут быть использованы на любой странице сайта,
 * к которой подключается страница "шаблон-шапка" template_header.jsp
 */

/**если выбрана строка, то становятся активными кнопки "Удалить пункт прайса" и "Изменить пункт прайса"
 * иначе - можно только внести новый товар (активна только кнопка "Добавить пункт прайса")
 */

function doActionButtons() {
    var rButton = document.getElementsByName('changedProductId');

    for (var i = 0; i < rButton.length; i++) {

        if (rButton[i].type == "radio" && rButton[i].checked) {
            var buttons = document.getElementsByName('buttonName');
            for (var j = 0; j < buttons.length; j++) {
                buttons[j].disabled = false;
            }

            return 1;
        }

    }
}

//если в строке таблицы сделаны изменения, то кнопка "Внести изменения" становится активной
function doActionChangeButton() {
    var changeButton = document.getElementsByName("buttonNameValidate");
    for (var j = 0; j < changeButton.length; j++) {
        changeButton[j].disabled = false;
    }
}

function validate(form) {
    var el = form.elements;


    if (!el.wineName.value || !el.winePrice.value || !el.wineNdsRate.value || !el.wineNameNew.value || !el.winePriceNew.value || !el.wineNdsRateNew.value) {
        alert("Заполните все обязательные поля формы!");
    }
    else {
        var changeButton = document.getElementsByName("buttonNameChangePage");
        for (var j = 0; j < changeButton.length; j++) {
            changeButton[j].disabled = false;
            alert("Для сохранения внесенных значений нажмите кнопку \"Внести изменения\"");
        }

    }
}