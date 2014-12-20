var gulp = require('gulp'),
  browserify = require('browserify'),
  reactify = require('reactify'),
  source = require('vinyl-source-stream');

gulp.task('jsx', function() {
  // Browserify/bundle the JS.
  browserify('./resources/public/js/src/main.jsx')
    .transform(reactify)
    .bundle()
    .pipe(source('bundle.js'))
    .pipe(gulp.dest('./resources/public/js/dist/'));
});
