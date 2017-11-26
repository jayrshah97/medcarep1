var loginController = angular.module('login-controller', ['ui.router','oc.lazyLoad']);
	loginController.controller('loginController', function($scope, $rootScope, $location,LoginAPI,toaster,$state,AuthenticationService,$cookieStore){
		$scope.switch = true;
		$scope.user={};
		$scope.login = function($event){
            $event.preventDefault();
				LoginAPI.doLogin($scope.user).success(function (response) {
					if(response.status){
						toaster.pop('success', "Login", response.message);
						if(response.user.type=="doctor"){
							AuthenticationService.SetCredentials($scope.user.phno, $scope.user.password,response.type,response.id);
							$state.go("doctordash");
							$rootScope.currentPage = "/doctor/dashboard"
						}
						else if(response.user.type=="doctor"){
							AuthenticationService.SetCredentials($scope.user.phno, $scope.user.password,response.type,response.id);
							$rootScope.adminDetails = response;
							$state.go("login");
						    $rootScope.currentPage = "/user/login"
						}
					}
					else{
                        toaster.pop('failure', "Login Again", response.message);
					}
				}).
				error(function(data, status, headers, config) {
					toaster.pop('error', "History", "There is some error to save basic info..!!");
				});
			},

			$scope.clickswitch = function ($event) {
				$scope.switch = !$scope.switch;
            }
	});