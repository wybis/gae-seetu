var dependents = [ 'ngRoute', 'ngSanitize' ];
dependents.push('classy');
dependents.push('classy-initScope');
dependents.push('ngStorage');
dependents.push('green.inputmask4angular');
//dependents.push('ui.bootstrap');
//dependents.push('ui.select');
var app = angular.module('app', dependents);

app.config(function($httpProvider) {
	$httpProvider.interceptors.push('generalHttpInterceptor');
});
//
//app.config(function(uiSelectConfig) {
//	uiSelectConfig.theme = 'select2';
//});
