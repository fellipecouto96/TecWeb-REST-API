(function () {
    'use strict';

    angular
        .module('tecWeb04ApiApp')
        .factory('Register', Register);

    Register.$inject = ['$resource'];

    function Register ($resource) {
        return $resource('api/register', {}, {});
    }
})();
