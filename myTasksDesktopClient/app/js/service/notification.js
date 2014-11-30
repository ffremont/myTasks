'use strict';
module.exports = ['$window', 'ICONS', function ($window, ICONS) {
        var Notification = $window.Notification || $window.mozNotification || $window.webkitNotification;
        Notification.requestPermission(function (permission) {
            $window.console.log(permission);
        });
        
        this.notifyError = function(tag, message, title){
            this.show(tag, ICONS.FAIL, title || "Erreur", message);
        };
        
        this.notifyInfo = function(tag, message, title){
            this.show(tag, ICONS.INFO, title || "information", message);
        };
        
        this.notifySuccess = function(tag, message, title){
            this.show(tag, ICONS.SUCCESS, title || "Succès", message);
        };
        
        this.show = function(myTag, myIcon, myTitle, myMessage, delay) {
            delay = delay || 0;
            
            $window.setTimeout(function () {
                var instance = new Notification(
                        myTitle, {
                            body: myMessage,
                            icon : myIcon,
                            tag : myTag,
                            dir : "rtl"
                        }
                );
                instance.onclick = function () {
                    // Something to do
                };
                instance.onerror = function () {
                    // Something to do
                };
                instance.onshow = function () {
                    // Something to do
                };
                instance.onclose = function () {
                    // Something to do
                };
            }, delay);
        };
        
    }];