angular.module('app').config([
    "$httpProvider",
     function($httpProvider){
         $httpProvider.defaults.useXDomain = true;
         $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
         delete $httpProvider.defaults.headers.common['X-Requested-With'];

     }
 ]);