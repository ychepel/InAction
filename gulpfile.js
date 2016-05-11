var gulp = require("gulp"),//http://gulpjs.com/
    util = require("gulp-util"),//https://github.com/gulpjs/gulp-util
    sass = require("gulp-sass"),//https://www.npmjs.org/package/gulp-sass
    autoprefixer = require('gulp-autoprefixer'),//https://www.npmjs.org/package/gulp-autoprefixer
    minifycss = require('gulp-minify-css'),//https://www.npmjs.org/package/gulp-minify-css
    rename = require('gulp-rename'),//https://www.npmjs.org/package/gulp-rename
    log = util.log;

var cssTarget = "src/main/webapp/resources/css/",
    sassFiles = "src/main/resources/scss/**/*.scss",
    imageFilesTarget = "src/main/webapp/resources/images/";

gulp.task("default", ["sass", "copy-resources"]);

gulp.task("sass", function () {
    log("Generating CSS files " + (new Date()).toString());
    gulp.src("src/main/resources/scss/all.scss")
        .pipe(sass({style: 'expanded'}))
        .pipe(autoprefixer("last 3 version", "safari 5", "ie 9"))
        .pipe(gulp.dest(cssTarget))
        .pipe(rename({suffix: '.min'}))
        .pipe(minifycss())
        .pipe(gulp.dest(cssTarget));
});

gulp.task("copy-resources", function () {
    log("Copy images");
    gulp.src("node_modules/material-design-icons/action/drawable-mdpi/ic_card_giftcard_black_48dp.png")
        .pipe(rename("example-image.png"))
        .pipe(gulp.dest(imageFilesTarget))
});

gulp.task("watch", function () {
    log("Watching scss files for modifications");
    gulp.watch(sassFiles, ["sass"]);
});
