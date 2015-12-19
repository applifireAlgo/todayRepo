Ext.define('Projone.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Projone.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Projone.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
