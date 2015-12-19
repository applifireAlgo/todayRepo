Ext.define('Projone.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Projone.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Projone.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
