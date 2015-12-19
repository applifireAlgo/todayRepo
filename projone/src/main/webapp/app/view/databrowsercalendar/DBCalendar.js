Ext.define('Projone.view.databrowsercalendar.DBCalendar', {
	extend : 'Projone.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Projone.view.databrowsercalendar.DBCalendarController',
	             'Projone.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
