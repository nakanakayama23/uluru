function setCurrentDate(){
	currentD = new Date();

	currentYear    = currentD.getFullYear();
	currentMonth   = currentD.getMonth() + 1;
	currentDate    = currentD.getDate();
	currentHours   = currentD.getHours();
	currentMinutes = currentD.getMinutes();

	/* 集合日時の年プルダウンリストに今年と来年の値を設定 */
	var select = document.getElementById('year');

	for (var i = currentYear; i < currentYear + 2; i++) {
	    var option = document.createElement('option');
	 
	    option.setAttribute('value', i);
	    option.innerHTML = i;
	 
	    select.appendChild(option);
	}

	/* 集合日時の"月"に現在日時を反映 */
	month_option = document.getElementById("month").getElementsByTagName('option');
   for(i = 0; i < month_option.length; i++){
      if(month_option[i].value == currentMonth){
         month_option[i].selected = true;
         break;
      }
   }

	/* 集合日時の"日"に現在日時を反映 */
	date_option = document.getElementById("date").getElementsByTagName('option');
   for(i = 0; i < date_option.length; i++){
      if(date_option[i].value == currentDate){
         date_option[i].selected = true;
         break;
      }
   }

	/* 集合日時の"時"に現在日時を反映 */
	hours_option = document.getElementById("hour").getElementsByTagName('option');
   for(i = 0; i < hours_option.length; i++){
      if(hours_option[i].value == currentHours){
         hours_option[i].selected = true;
         break;
      }
   }

	/* 集合日時の"分"に現在日時を反映 */
	minutes_option = document.getElementById("minute").getElementsByTagName('option');
   for(i = 0; i < minutes_option.length; i++){
      if(minutes_option[i].value == currentMinutes){
         minutes_option[i].selected = true;
         break;
      }
   }
}