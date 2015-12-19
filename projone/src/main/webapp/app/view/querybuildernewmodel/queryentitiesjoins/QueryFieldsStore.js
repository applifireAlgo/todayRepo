Ext.define('Projone.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Projone.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Projone.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
