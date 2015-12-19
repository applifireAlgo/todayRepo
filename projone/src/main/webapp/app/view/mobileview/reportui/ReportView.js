Ext.define('Projone.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Projone.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Projone.view.mobileview.reportui.datachart.DataChartViewTab',
			'Projone.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Projone.view.mobileview.reportui.ReportViewController' ,
			'Projone.view.mobileview.fw.DataPointPanel',
			'Projone.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
