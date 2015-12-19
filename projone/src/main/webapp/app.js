/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Projone',

    extend: 'Projone.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Projone.view.mainleftmenutree.MainPanel':'Projone.view.mobileview.login.Login',
    //autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Projone.view.login.LoginPage':'Projone.view.mobileview.login.LoginPage',//'Projone.view.login.Login'
    	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Projone.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
