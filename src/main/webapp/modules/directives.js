function headerNavigatorDirective() {
	return {

		restrict : 'E',

		replace : true,

		templateUrl : 'modules/zgeneral/headerNavigatorDirective.html',

		link : function($scope) {
		}
	};
}
appDirectives.directive('headerNavigatorDirective',
		[ headerNavigatorDirective ]);

function breadCrumbDirective() {
	return {

		restrict : 'E',

		replace : true,

		templateUrl : 'modules/zgeneral/breadCrumbDirective.html',

		link : function($scope) {
		}
	};
}
appDirectives.directive('breadCrumbDirective', [ breadCrumbDirective ]);

function footerBarDirective() {
	return {

		restrict : 'E',

		replace : true,

		templateUrl : 'modules/zgeneral/footerBarDirective.html',

		link : function($scope) {
		}
	};
}
appDirectives.directive('footerBarDirective', [ footerBarDirective ]);

function footerNavigatorDirective() {
	return {

		restrict : 'E',

		replace : true,

		templateUrl : 'modules/zgeneral/footerNavigatorDirective.html',

		link : function($scope) {
		}
	};
}
appDirectives.directive('footerNavigatorDirective',
		[ footerNavigatorDirective ]);
