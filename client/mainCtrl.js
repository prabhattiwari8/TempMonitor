/**
 * Created by cwr.prabhat.tiwari on 1/19/15.
 */


angular.module('app')
    .controller('MainCtrl', function ($scope,$http) {
        $scope.title = 'Temperature Monitor App';
        $scope.temperatures=[];
         $scope.new ={};
         var uuid="";
        $scope.addTemperature =function(){
        generateUUID();
        var params = {
            IData: $scope.new.temperature,
            Key: uuid
        }
        var req = {
         method: 'POST',
         url: 'http://localhost:8080/addData',
         params: params
        }
       $http(req).
         success(function(data, status, headers, config) {
           // this callback will be called asynchronously
           // when the response is available
           $scope.status=data.result;
         }).
         error(function(data, status, headers, config) {
           // called asynchronously if an error occurs
           // or server returns response with an error status.
           $scope.status=data.error+" "+ data.message;
         });
         $scope.new ={};
        };
        
          $scope.getTemperature =function(){
          var params = {
                         Key: uuid
                       }
               var req = {
                method: 'GET',
                url: 'http://localhost:8080/calculateMedian',
                params: params
                }
              $http(req).
                success(function(data, status, headers, config) {
                  // this callback will be called asynchronously
                  // when the response is available
                  $scope.status=data.result;
                  $scope.medianTemp=data.iMedian;

                }).
                error(function(data, status, headers, config) {
                  // called asynchronously if an error occurs
                  // or server returns response with an error status.
                  $scope.status=data.error+" "+ data.message;
                });

               };

               function generateUUID(){
                   var d = new Date().getTime();
                   if(uuid==""){
                    uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
                       var r = (d + Math.random()*16)%16 | 0;
                       d = Math.floor(d/16);
                       return (c=='x' ? r : (r&0x3|0x8)).toString(16);
                   });
                   }
                   return uuid;
               };

    });