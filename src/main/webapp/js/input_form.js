function setCurrentDate(){
	currentD = new Date();

	currentYear    = currentD.getFullYear();
	currentMonth   = currentD.getMonth() + 1;
	currentDate    = currentD.getDate();
	currentHours   = currentD.getHours();
	currentMinutes = currentD.getMinutes();

	/* �W�������̔N�v���_�E�����X�g�ɍ��N�Ɨ��N�̒l��ݒ� */
	var select = document.getElementById('year');

	for (var i = currentYear; i < currentYear + 2; i++) {
	    var option = document.createElement('option');
	 
	    option.setAttribute('value', i);
	    option.innerHTML = i;
	 
	    select.appendChild(option);
	}

	/* �W��������"��"�Ɍ��ݓ����𔽉f */
	month_option = document.getElementById("month").getElementsByTagName('option');
   for(i = 0; i < month_option.length; i++){
      if(month_option[i].value == currentMonth){
         month_option[i].selected = true;
         break;
      }
   }

	/* �W��������"��"�Ɍ��ݓ����𔽉f */
	date_option = document.getElementById("date").getElementsByTagName('option');
   for(i = 0; i < date_option.length; i++){
      if(date_option[i].value == currentDate){
         date_option[i].selected = true;
         break;
      }
   }

	/* �W��������"��"�Ɍ��ݓ����𔽉f */
	hours_option = document.getElementById("hour").getElementsByTagName('option');
   for(i = 0; i < hours_option.length; i++){
      if(hours_option[i].value == currentHours){
         hours_option[i].selected = true;
         break;
      }
   }

	/* �W��������"��"�Ɍ��ݓ����𔽉f */
	minutes_option = document.getElementById("minute").getElementsByTagName('option');
   for(i = 0; i < minutes_option.length; i++){
      if(minutes_option[i].value == currentMinutes){
         minutes_option[i].selected = true;
         break;
      }
   }
}

/* ���邤�N�̔��� */
function isLeapYear(year){
	if (year % 4 == 0 && (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))){
		return true;
	}else{
		return false;
	}
}

/* ���t�v���_�E�����X�g�̓��I�ύX */
function chg_date_selection(){
	var select_year = document.forms.inputForm.year;
	var select_month = document.forms.inputForm.month;
	var select_date = document.forms.inputForm.day;

	select_date.options.length = 0;

	var selected_y = select_year.options[select_year.selectedIndex].value;
	var selected_m = select_month.options[select_month.selectedIndex].value;

	if(selected_m == 4 || selected_m == 6 || selected_m == 9 || selected_m == 11){
		for(var i = 0; i < 30; i++){
			select_date.options[i] = new Option(i+1);
		}
	}else if(selected_m == 2){
		if(isLeapYear(selected_y)){
			for(var i = 0; i < 29; i++){
				select_date.options[i] = new Option(i+1);
			}
		}else{
			for(var i = 0; i < 28; i++){
				select_date.options[i] = new Option(i+1);
			}
		}
	}else{
		for(var i = 0; i < 31; i++){
			select_date.options[i] = new Option(i+1);
		}
	}
}

