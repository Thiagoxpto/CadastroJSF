/* aplica a barra de rolagens dinamicamente ao menu (atualiza a altura)
 * depends: jquery.mCustomScrollbar.concat.min.js */
function loadMenu() {
	var menu = $("#menu");
	
	var screenHeight = $(window).height();
	menu.height(screenHeight - 80);
	menu.mCustomScrollbar({
        theme:"dark"
    });
	
	var menuHeader = $('#menu .ui-panelmenu .ui-panelmenu-panel.header');
	menuHeader.css('width', menuHeader.closest('div.mCSB_container').width());
}

/* funcao para resetar os valores do form */
function resetForm(el) {
	
	var form = $(el).closest('form');

	$(':input', form)
		.not(':button, :submit, :reset, :hidden').val('')
		.removeAttr('checked')
		.removeAttr('selected');
}

/* seta o zindex do elemento para o 'mais alto' da tela */
function moveUp(id){
	$(document.getElementById(id)).css({'z-index' : getMaxZIndex()+100});
}

function getMaxZIndex(){
	var maxZ = Math.max.apply(
			null, 
			$.map($('body > *'), function(e, n) {
				if ($(e).css('position') != 'static')
					return parseInt($(e).css('z-index')) || 1;
			})
		);
	return maxZ;
}

//reescrevendo o evento show... adicionando evento a ser disparado: beforeShow
(function ($) {

    //Extend show() so that it trigger our event when called
    var show = $.fn.show;
    $.fn.show = function () {
        var ret = show.apply(this, arguments); //Read comments about these part at the stackoverflow linked above

        $(this).trigger("beforeShow"); //Trigger our new onShow event

        return ret; //Return object so that it can propagate
    };

    //Define new event functions
    $.fn.beforeShow = function (callback) {
        if (callback != null) {
            $(this).on("beforeShow", function () {
                callback(); //Trigger callback
            });
        } else {
            $(this).trigger("beforeShow"); //If no callback exist we trigger the event
        }
        return this;
    };
})(jQuery);