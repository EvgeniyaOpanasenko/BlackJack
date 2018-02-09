'use strict';

angular.module('crudApp').factory('GameService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllGames: loadAllGames,
                getAllGames: getAllGames,
                getGame: getGame,
                createGame: createGame,
                updateGame: updateGame,
                removeGame: removeGame
            };

            return factory;

            function loadAllGames() {
                console.log('Fetching all games');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all games');
                            $localStorage.games = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading games');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllGames(){
                return $localStorage.games;
            }

            function getGame(id) {
                console.log('Fetching Game with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Game with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading game with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createGame(game) {
                console.log('Creating Game');
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API, game)
                    .then(
                        function (response) {
                            loadAllGames();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Game : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateGame(game, id) {
                console.log('Updating Game with id '+id);
                var deferred = $q.defer();
                $http.put(urls.USER_SERVICE_API + id, game)
                    .then(
                        function (response) {
                            loadAllGames();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Game with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeGame(id) {
                console.log('Removing Game with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllGames();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Game with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);