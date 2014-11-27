/* 
 * Version : ${project.version}
 */
module.exports = function (grunt) {
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        clean: ["dist/", "bower_components/"],
        browserify: {
            js: {
                src: 'public_html/js/app.js',
                dest: 'dist/js/app.js'
            }
        },
        copy: {
            HtmlCss: {
                expand: true,
                cwd: 'public_html/',
                src: ['**', '!js/**'],
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
        browserSync: {
            bsFiles: {
                src: './dist/**'
            },
            options: {
                server: {
                    baseDir: "./dist"
                }
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
                files: ['public_html/**'],
                tasks: ['default']
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

    // The default tasks to run when you type: grunt
    grunt.registerTask('default', ['bower:install', 'browserify', 'copy']);
};
