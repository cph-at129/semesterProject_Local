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

            $scope.flights = [];
            $scope.depDate = new Date();
            $scope.flyFrom = 'CPH';
            $scope.flyTo = 'BCN';
            $scope.seats = 0;

            $scope.getAllFlightsFrom = function () {
                console.log("In getAllFlightsFrom function");
                $scope.flights = [];//clear the flights
                
                //convert the data 
                var year = $scope.depDate.getFullYear();
                var month = $scope.depDate.getMonth();
                var day = $scope.depDate.getDate();
                
                var rawDate = new Date(year, month, day, 1);
                
                var dateJSON = JSON.stringify(rawDate);//Convert into a JSON-string
                var dateStr = JSON.parse(dateJSON);//Convert back into JavaScript
                //var dateFromJson = new Date(dateStr);//JavaScript provides a Date Constructor that takes an ISO-8601 string

                
                InfoFactory.getAllFlightsFrom($scope.flyFrom, dateStr, $scope.seats)
                
                        .then(function (response) {
                            $scope.flights = response.data;
                            console.log("Flights recieved: " + $scope.flights);
                        }, function (error) {
                            console.log("Error in getAllFlightsFrom($scope.flyFrom, dateStr, $scope.seats)");
                        });
                
                
            };
            $scope.getAllFlightsFromTo = function () {

                //var preparedURL = 'http://angularairline-plaul.rhcloud.com/api/flightinfo/CPH/2016-01-03T00:00:00.000Z/2';
                var preparedURL = 'http://angularairline-plaul.rhcloud.com/api/flightinfo/'
                        + $scope.flyFrom + '/' + $scope.depDate + '/' + $scope.seats;

                alert("URL format: " + preparedURL);

                $http({
                    method: 'GET',
                    url: preparedURL

                }).then(function successCallback(response) {

                    $scope.flightsFrom = response.data;
                }, function errorCallback(error) {
                    alert("error bro");
                });
            }


        });