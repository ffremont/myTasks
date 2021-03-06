/* 
 * Version : ${project.version}
 */
module.exports = function (grunt) {
    var proxySnippet = require('grunt-connect-proxy/lib/utils').proxyRequest;
    var mountFolder = function (connect, dir) {
        return connect.static(require('path').resolve(dir));
    };
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        clean: ["dist/", "bower_components/"],
        browserify: {
            js: {
                src: 'app/js/app.js',
                dest: 'dist/js/app.js'
            }
        },
        copy: {
            HtmlCss: {
                expand: true,
                cwd: 'app/',
                src: ['**', '!js/**', '!mocks/**'],
                dest: 'dist/'
            },
            bootrap: {
                expand: true,
                cwd: 'bower_components/bootstrap/dist/',
                src: ['**', '!js/**'],
                dest: 'dist/css/bootstrap'
            },
            awesome: {
                expand: true,
                cwd: 'bower_components/components-font-awesome/',
                src: ['css/**', 'fonts/**'],
                dest: 'dist/css/font-awesome'
            },
            ngTagsInput: {
                expand: true,
                cwd: 'bower_components/ng-tags-input/',
                src: ['ng-tags-input.min.css'],
                dest: 'dist/css'
            }
        },
        bower: {
            install: {},
            options: {
                copy: false
            }
        },
        watch: {
            prepare: {
                files: ['app/**'],
                tasks: ['default']
            }
        },
        easymock: {
            api: {
                options: {
                    port: 8888,
                    keepalive: false,
                    path: 'mocks',
                    config: {
                        routes: [
                            "/api/login"
                        ]
                    }
                }
            }
        },
        connect: {
            server: {
                options: {
                    port: 9999,
                    hostname: 'localhost',
                    base: ['./dist'],
                    keepalive: false,
                    middleware: function (connect, options, middlewares) {
                        // inject a custom middleware 
                        middlewares.unshift(proxySnippet);
                        middlewares.unshift(function (req, res, next) {
                            res.setHeader('Access-Control-Allow-Origin',          '*');
                            res.setHeader('Access-Control-Allow-Methods',     'GET,HEAD,PUT,PATCH,POST,DELETE');
                            res.setHeader('Allow',     'GET, HEAD, PUT, PATCH, POST, DELETE');
                            
                            return next();
                        });                      
                        
                        return middlewares;
                    }
                },
                proxies: [
                    {
                        context: '/api',
                        host: 'localhost',
                        port: 8888
                    }
                ]
            }
        }
    });
    // Load the npm installed tasks
    grunt.loadNpmTasks('grunt-browserify');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-browser-sync');
    grunt.loadNpmTasks('grunt-bower-task');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-easymock');

    grunt.loadNpmTasks('grunt-contrib-connect');
    grunt.loadNpmTasks('grunt-connect-proxy');

    // The default tasks to run when you type: grunt
    grunt.registerTask('default', ['bower:install', 'browserify', 'copy']);

    grunt.registerTask('dev', ['easymock', 'configureProxies:server', 'connect', 'watch']);
};
