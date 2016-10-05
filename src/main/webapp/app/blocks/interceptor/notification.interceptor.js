(function() {
    'use strict';

    angular
        .module('tecWeb04ApiApp')
        .factory('notificationInterceptor', notificationInterceptor);

    notificationInterceptor.$inject = ['$q', 'AlertService'];

    function notificationInterceptor ($q, AlertService) {
        var service = {
            response: response
        };

        return service;

        function response (response) {
            var alertKey = response.headers('X-tecWeb04ApiApp-alert');
            if (angular.isString(alertKey)) {
                AlertService.success(alertKey, { param : response.headers('X-tecWeb04ApiApp-params')});
            }
            return response;
        }
    }
})();
