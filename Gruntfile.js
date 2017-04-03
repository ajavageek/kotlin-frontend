module.exports = function (grunt) {

    grunt.initConfig({
        clean: 'dist/**',
        exec: {
            cmd: 'kotlinc-js src -output dist/script.js'
        },
        copy: {
            files: {
                expand: true,
                flatten: true,
                src: ['src/**/*.html', 'src/**/*.css'],
                dest: 'dist'
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-exec');

    grunt.registerTask('default', ['exec', 'copy']);
};
