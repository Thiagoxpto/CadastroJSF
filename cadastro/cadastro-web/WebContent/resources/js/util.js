/**
 * isBlankOrNull
 */
function isBlankOrNull(inputName)
{
	var inputValue = $(inputName).val();
	
	if(inputValue != null)
	{
		inputValue = $.trim(inputValue);
	}
	return ((inputValue == null) || (inputValue.length == 0));
}

/**
 * isBlankOrNullSelect
 */
function isBlankOrNullSelect(widgetVar)
{
	var inputValue = PF(widgetVar).getSelectedValue();
	
	if(inputValue != null)
	{
		inputValue = $.trim(inputValue);
	}
	return ((inputValue == null) || (inputValue.length == 0));
}

/**
 * isBlankOrNullRadio
 */
function isBlankOrNullRadio(inputName)
{
	var inputValue = getInputRadioValue(inputName);
	
	if(inputValue != null)
	{
		inputValue = $.trim(inputValue);
	}
	return ((inputValue == null) || (inputValue.length == 0));
}

/**
 * isBlankOrNullPickListTarget
 */
function isBlankOrNullPickListTarget(inputName)
{
	var lengthSelecionados = $('#'+inputName+'_target').children('option').length;
	
	if(lengthSelecionados > 0)
	{
		return (false);
	}
	else
	{
		return (true);
	}
}

/**
 * isGreaterThan
 */
function isGreaterThan(inputName, size)
{
	var inputValue = $(inputName).val();
	
	if(inputValue != null)
	{
		inputValue = $.trim(inputValue);
	}
	
	if(inputValue.length < size)
	{
		return false;
	}
	else
	{
		return true;
	}
}

/**
 * getInputRadioValue
 */
function getInputRadioValue(inputName)
{
	var inputValue = $('input[name="'+inputName+'"]:checked').val();
	
	return(inputValue);
}

/* funcao que verifica se existe uma string (str) em outra (orig) */
function contains(str, orig) {
	return orig.indexOf(str) > -1;
}

/* funcao que verifica se existe uma string (str) em outra (orig) - case insensitive */
function containsIgnoreCase(str, orig) {
	var strUp = str.toUpperCase(), origUp = orig.toUpperCase();
	return contains(strUp, origUp);
}

/* objeto com funcoes utilitarias */
function Utils () {
	
	/* funções utilitárias para campos geridos pelo Primefaces */
	
	/**
	 * Recupera um campo, ou um grupo de campos do formulario.
	 * 
	 * @param widgetVar - atributo widgetVar do primefaces
	 * @param group - true se for um grupo de campos, false se for apenas um campo
	 */
	this._field = function(widgetVar, group) {
		return (group) ? PF('widget_' + widgetVar) : PF(widgetVar);
	},
	/**
	 * Recupera um campo do formulario.
	 * 
	 * @param widgetVar - atributo widgetVar do primefaces
	 */
	this.getField = function(widgetVar) {
		var field = this._field(widgetVar, false).input;
		return (field) ? field : this._field(widgetVar, false).jq;
	},
	/**
	 * Recupera um grupo de campos do formulario (do tipo radio ou checkbox).
	 * 
	 * @param widgetVar - atributo widgetVar do primefaces
	 */
	this.getFields = function(widgetVar) {
		var fields = this._field(widgetVar, true).inputs;
		return (fields) ? fields : this._field(widgetVar, true).jq;
	},
	/**
	 * Verifica se o campo esta preenchido.
	 * 
	 * @param widgetVar - atributo widgetVar do primefaces
	 */
	this.isFilled = function(widgetVar) {
		var val = this.getField(widgetVar).val();
		return val != null && $.trim(val) != '';
	},
	/**
	 * Verifica se o campo do Primefaces Extensions esta preenchido.
	 * 
	 * @param widgetVar - atributo widgetVar do primefaces
	 */
	this.isFilledExt = function(widgetVar) {
		var val = PF(widgetVar).getValue();
		return val != null && $.trim(val) != '';
	},
	/**
	 * Verifica se o campo esta marcado (checked), seja radio ou checkbox.
	 * @param widgetVar - atributo widgetVar do primefaces
	 */
	this.isFieldChecked = function(widgetVar) {
		return this.getField(widgetVar).is(':checked');
	},
	/**
	 * Verifica se um campo de um grupo esta marcado (checked), seja radio ou checkbox.
	 * 
	 * @param widgetVar - atributo widgetVar do primefaces
	 */
	this.isFieldGroupChecked = function(widgetVar) {
		return this.getFields(widgetVar).is(':checked');
	},
	/**
	 * Retorna a lista de itens selecionados em uma pickList do Primefaces.
	 * 
	 * @param widgetVar - atributo widgetVar do primefaces
	 */
	this.getTargetList = function(widgetVar) {
		return PF(widgetVar) ? PF(widgetVar).targetList.children() : [];
	}
	/**
	 * Habilita ou desabilita um botão.
	 * 
	 * @param widgetVar - atributo widgetVar do primefaces
	 * @param enable - true habilita, false desabilita
	 */
	this.enableButton = function (widgetVar, enable) {
		var btn = PF(widgetVar);
		if (enable) {
			btn.enable();
		} else {
			btn.disable();
		}	
	},
	
	/**
	 * isBlankOrNull
	 */
	this.isBlankOrNull = function(inputName)
	{
		var inputValue = $(inputName).val();
		
		if(inputValue != null)
		{
			inputValue = $.trim(inputValue);
		}
		return ((inputValue == null) || (inputValue.length == 0));
	},

	/**
	 * isBlankOrNullSelect
	 */
	this.isBlankOrNullSelect = function(widgetVar)
	{
		var inputValue = PF(widgetVar).getSelectedValue();
		
		if(inputValue != null)
		{
			inputValue = $.trim(inputValue);
		}
		return ((inputValue == null) || (inputValue.length == 0));
	}

	/**
	 * isBlankOrNullRadio
	 */
	this.isBlankOrNullRadio = function (inputName)
	{
		var inputValue = getInputRadioValue(inputName);
		
		if(inputValue != null)
		{
			inputValue = $.trim(inputValue);
		}
		return ((inputValue == null) || (inputValue.length == 0));
	}

	/**
	 * isBlankOrNullPickListTarget
	 */
	this.isBlankOrNullPickListTarget = function (inputName)
	{
		var lengthSelecionados = $('#'+inputName+'_target').children('option').length;
		
		if(lengthSelecionados > 0)
		{
			return (false);
		}
		else
		{
			return (true);
		}
	},
	/**
	 * Busca um campo radio pelo nome e que esteja marcado ('checked').
	 * 
	 * @param inputName nome do campo (atributo name - input)
	 */
	this.isGreaterThan = function (widgetVar, size, removeMask)
	{
		var val = this.getField(widgetVar).val();

		if (val != null)
		{
			val = $.trim(val);
			
			if(removeMask)
			{
				val = val.replace(/[^0-9]+/g, '');
			}
			
			if (val.length < size)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		return false;
	},
	/**
	 * Busca um campo radio pelo nome e que esteja marcado ('checked').
	 * 
	 * @param inputName
	 *            nome do campo (atributo name - input)
	 * 
	 * @return input - jquery object
	 */
	this.getInputRadioValue = function (inputName)
	{
		var inputValue = $('input[name="'+inputName+'"]:checked').val();
		
		return(inputValue);
	},
	/**
	 * Função que verifica se existe uma string (str) em outra (orig).
	 * 
	 * @param str trecho que queremos procurar na String orig
	 * @param orig String que será verificada se esta contém a String str
	 * 
	 * @return true, se str está contida em orig
	 */
	this.contains = function (str, orig) {
		return orig.indexOf(str) > -1;
	},
	/**
	 * Função que verifica se existe uma string (str) em outra (orig) - case insensitive.
	 * 
	 * @param str trecho que queremos procurar na String orig
	 * @param orig String que será verificada se esta contém a String str
	 * 
	 * @return true, se str está contida em orig
	 */
	this.containsIgnoreCase = function (str, orig) {
		var strUp = str.toUpperCase(), origUp = orig.toUpperCase();
		return contains(strUp, origUp);
	},
	/**
	 * Desabilita o submit quando clicado o enter no form.
	 */
	this.stopSubmitOnEnter = function () {
		$(document).on("keypress", 'input', function (e) {
		    var code = e.keyCode || e.which;
		    if (code == 13) {
		        e.preventDefault();
		        return false;
		    }
		});
	}
};

var utils = new Utils();