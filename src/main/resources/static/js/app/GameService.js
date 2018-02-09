'use strict';

angular.module('crudApp').factory('GameService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                getAllGames: getAllGames,
                getGame: getGame, // when hit or bust or stand need to get game and update it
                createGame: createGame,
                updateGame: updateGame
            };

            return factory;

            function loadGame() {
                console.log('Fetching all games');
                var deferred = $q.defer();
                $http.get(urls.GAME_SERVICE_API)
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
                $http.get(urls.GAME_SERVICE_API + id)
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
                $http.post(urls.GAME_SERVICE_API, game)
                    .then(
                        function (response) {
                            loadGame();
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
                $http.put(urls.GAME_SERVICE_API + id, game)
                    .then(
                        function (response) {
                            loadGame();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Game with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
        }
    ]);