Ext.define('Projone.view.usermanagement.admin.AdminUserManagement', {
	extend : 'Ext.tab.Panel',
	requires : ['Projone.view.usermanagement.admin.UserPasswordReset',
	            'Projone.view.usermanagement.admin.AddUserDetails',
	            'Projone.view.usermanagement.admin.ViewUser'],
	xtype : 'adminUserMainView',
	margin : '3 0 0 0',
	items:[{
				xtype:'addUserDetails',
				itemId:'addUserDetails',
				title:'Add User',
				iconCls:'addUserTabIcon',
				tooltip:'Add new user'
			},
			{
				xtype:'viewUser',
				itemId:'viewUser',
				title:'View User',
				iconCls:'viewUserTabIcon',
				tooltip:'View users details'
			},
			{
				xtype:'userPwdResetView',
				itemId:'userPwdResetView',
				title:'User Password Settings',
				iconCls:'settingTabIcon',
				tooltip:'User Account settings'
			}]
});