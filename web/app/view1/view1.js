'use strict';

angular.module('myApp.view1', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view1', {
                    templateUrl: 'app/view1/view1.html',
                    controller: 'View1Ctrl',
                    controllerAs: 'ctrl'
                });
            }])

        .controller('View1Ctrl', function ($http, $scope, InfoFactory) {

//            $scope.searchFlights = function(){
//                
//                if($scope.flyTo == ''){
//                    
//                    getAllFlightsFrom();
//                }else{
//                    
//                    getAllFlightsFromTo();
//                }
//            };

            $scope.flights = [];
            $scope.depDate = new Date();
            $scope.flyFrom = 'CPH';
            $scope.flyTo = '';
            $scope.seats = 0;
            
            $scope.isError = false;
            $scope.errorMessage = "Sorry for the inconvenience";
            
            $scope.getAllFlightsFrom = function () {
                $scope.isError = false;
                $scope.flights = [];//clear the flights
                
                //convert the data 
                var year = $scope.depDate.getFullYear();
                var month = $scope.depDate.getMonth();
                var day = $scope.depDate.getDate();
                
                var rawDate = new Date(year, month, day, 1);
                
                //alert(year + "-" + month + "-" + day);
                
                var dateJSON = JSON.stringify(rawDate);//Convert into a JSON-string
                var dateStr = JSON.parse(dateJSON);//Convert back into JavaScript
                //var dateFromJson = new Date(dateStr);//JavaScript provides a Date Constructor that takes an ISO-8601 string

                
                InfoFactory.getAllFlightsFrom($scope.flyFrom, dateStr, $scope.seats)
                
                        .then(function (response) {
                            $scope.flights = response.data;
                        }, function (error) {
                             $scope.isError = true;
                             $scope.errorMessage = error.message;
                        });
                
                
            };
            $scope.getAllFlightsFromTo = function () {
                $scope.isError = false;//hide the error bar
                $scope.flights = [];//clear the flights
                
                //convert the data 
                var year = $scope.depDate.getFullYear();
                var month = $scope.depDate.getMonth();
                var day = $scope.depDate.getDate();
                
                var rawDate = new Date(year, month, day, 1);
                
                var dateJSON = JSON.stringify(rawDate);//Convert into a JSON-string
                var dateStr = JSON.parse(dateJSON);//Convert back into JavaScript
                //var dateFromJson = new Date(dateStr);//JavaScript provides a Date Constructor that takes an ISO-8601 string

                
                InfoFactory.getAllFlightsFromTo($scope.flyFrom, $scope.flyTo, dateStr, $scope.seats)
                
                        .then(function (response) {
                            $scope.flights = response.data;
                        }, function (error) {
                            $scope.isError = true;
                             $scope.errorMessage = error.message;
                        });
            };


        });
        
        