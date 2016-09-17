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

function doActionChangeButton() {
    var changeButton = document.getElementsByName('buttonName');
    for (var j = 0; j < changeButton.length; j++) {
        changeButton[i].disabled = false;
    }
}

