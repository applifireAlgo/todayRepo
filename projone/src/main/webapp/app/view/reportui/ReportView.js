Ext.define('Projone.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Projone.view.reportui.querycriteria.QueryCriteriaView',
			'Projone.view.reportui.datachart.DataChartViewTab',
			'Projone.view.reportui.datachart.DataChartViewPanel',
			'Projone.view.reportui.ReportViewController' ,
			'Projone.view.fw.MainDataPointPanel',
			'Projone.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
