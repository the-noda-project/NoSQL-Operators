function _inherits(subClass, superClass) {
  if (typeof superClass !== "function" && superClass !== null) {
    throw new TypeError("Super expression must either be null or a function");
  }
  subClass.prototype = Object.create(superClass && superClass.prototype, {
    constructor: { value: subClass, writable: true, configurable: true },
  });
  if (superClass) _setPrototypeOf(subClass, superClass);
}

function _setPrototypeOf(o, p) {
  _setPrototypeOf =
    Object.setPrototypeOf ||
    function _setPrototypeOf(o, p) {
      o.__proto__ = p;
      return o;
    };
  return _setPrototypeOf(o, p);
}

function _createSuper(Derived) {
  var hasNativeReflectConstruct = _isNativeReflectConstruct();
  return function () {
    var Super = _getPrototypeOf(Derived),
      result;
    if (hasNativeReflectConstruct) {
      var NewTarget = _getPrototypeOf(this).constructor;
      result = Reflect.construct(Super, arguments, NewTarget);
    } else {
      result = Super.apply(this, arguments);
    }
    return _possibleConstructorReturn(this, result);
  };
}

function _possibleConstructorReturn(self, call) {
  if (call && (typeof call === "object" || typeof call === "function")) {
    return call;
  }
  return _assertThisInitialized(self);
}

function _assertThisInitialized(self) {
  if (self === void 0) {
    throw new ReferenceError(
      "this hasn't been initialised - super() hasn't been called"
    );
  }
  return self;
}

function _isNativeReflectConstruct() {
  if (typeof Reflect === "undefined" || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if (typeof Proxy === "function") return true;
  try {
    Date.prototype.toString.call(Reflect.construct(Date, [], function () {}));
    return true;
  } catch (e) {
    return false;
  }
}

function _getPrototypeOf(o) {
  _getPrototypeOf = Object.setPrototypeOf
    ? Object.getPrototypeOf
    : function _getPrototypeOf(o) {
        return o.__proto__ || Object.getPrototypeOf(o);
      };
  return _getPrototypeOf(o);
}

function _toConsumableArray(arr) {
  return (
    _arrayWithoutHoles(arr) ||
    _iterableToArray(arr) ||
    _unsupportedIterableToArray(arr) ||
    _nonIterableSpread()
  );
}

function _nonIterableSpread() {
  throw new TypeError(
    "Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method."
  );
}

function _unsupportedIterableToArray(o, minLen) {
  if (!o) return;
  if (typeof o === "string") return _arrayLikeToArray(o, minLen);
  var n = Object.prototype.toString.call(o).slice(8, -1);
  if (n === "Object" && o.constructor) n = o.constructor.name;
  if (n === "Map" || n === "Set") return Array.from(o);
  if (n === "Arguments" || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n))
    return _arrayLikeToArray(o, minLen);
}

function _iterableToArray(iter) {
  if (typeof Symbol !== "undefined" && Symbol.iterator in Object(iter))
    return Array.from(iter);
}

function _arrayWithoutHoles(arr) {
  if (Array.isArray(arr)) return _arrayLikeToArray(arr);
}

function _arrayLikeToArray(arr, len) {
  if (len == null || len > arr.length) len = arr.length;
  for (var i = 0, arr2 = new Array(len); i < len; i++) {
    arr2[i] = arr[i];
  }
  return arr2;
}

function _defineProperties(target, props) {
  for (var i = 0; i < props.length; i++) {
    var descriptor = props[i];
    descriptor.enumerable = descriptor.enumerable || false;
    descriptor.configurable = true;
    if ("value" in descriptor) descriptor.writable = true;
    Object.defineProperty(target, descriptor.key, descriptor);
  }
}

function _createClass(Constructor, protoProps, staticProps) {
  if (protoProps) _defineProperties(Constructor.prototype, protoProps);
  if (staticProps) _defineProperties(Constructor, staticProps);
  return Constructor;
}

function _classCallCheck(instance, Constructor) {
  if (!(instance instanceof Constructor)) {
    throw new TypeError("Cannot call a class as a function");
  }
}

(window["webpackJsonp"] = window["webpackJsonp"] || []).push([
  ["main"],
  {
    /***/
    "./$$_lazy_route_resource lazy recursive":
      /*!******************************************************!*\
    !*** ./$$_lazy_route_resource lazy namespace object ***!
    \******************************************************/

      /*! no static exports found */

      /***/
      function $$_lazy_route_resourceLazyRecursive(module, exports) {
        function webpackEmptyAsyncContext(req) {
          // Here Promise.resolve().then() is used instead of new Promise() to prevent
          // uncaught exception popping up in devtools
          return Promise.resolve().then(function () {
            var e = new Error("Cannot find module '" + req + "'");
            e.code = "MODULE_NOT_FOUND";
            throw e;
          });
        }

        webpackEmptyAsyncContext.keys = function () {
          return [];
        };

        webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
        module.exports = webpackEmptyAsyncContext;
        webpackEmptyAsyncContext.id = "./$$_lazy_route_resource lazy recursive";
        /***/
      },

    /***/
    "./node_modules/moment/locale sync recursive ^\\.\\/.*$":
      /*!**************************************************!*\
    !*** ./node_modules/moment/locale sync ^\.\/.*$ ***!
    \**************************************************/

      /*! no static exports found */

      /***/
      function node_modulesMomentLocaleSyncRecursive$(
        module,
        exports,
        __webpack_require__
      ) {
        var map = {
          "./af": "./node_modules/moment/locale/af.js",
          "./af.js": "./node_modules/moment/locale/af.js",
          "./ar": "./node_modules/moment/locale/ar.js",
          "./ar-dz": "./node_modules/moment/locale/ar-dz.js",
          "./ar-dz.js": "./node_modules/moment/locale/ar-dz.js",
          "./ar-kw": "./node_modules/moment/locale/ar-kw.js",
          "./ar-kw.js": "./node_modules/moment/locale/ar-kw.js",
          "./ar-ly": "./node_modules/moment/locale/ar-ly.js",
          "./ar-ly.js": "./node_modules/moment/locale/ar-ly.js",
          "./ar-ma": "./node_modules/moment/locale/ar-ma.js",
          "./ar-ma.js": "./node_modules/moment/locale/ar-ma.js",
          "./ar-sa": "./node_modules/moment/locale/ar-sa.js",
          "./ar-sa.js": "./node_modules/moment/locale/ar-sa.js",
          "./ar-tn": "./node_modules/moment/locale/ar-tn.js",
          "./ar-tn.js": "./node_modules/moment/locale/ar-tn.js",
          "./ar.js": "./node_modules/moment/locale/ar.js",
          "./az": "./node_modules/moment/locale/az.js",
          "./az.js": "./node_modules/moment/locale/az.js",
          "./be": "./node_modules/moment/locale/be.js",
          "./be.js": "./node_modules/moment/locale/be.js",
          "./bg": "./node_modules/moment/locale/bg.js",
          "./bg.js": "./node_modules/moment/locale/bg.js",
          "./bm": "./node_modules/moment/locale/bm.js",
          "./bm.js": "./node_modules/moment/locale/bm.js",
          "./bn": "./node_modules/moment/locale/bn.js",
          "./bn.js": "./node_modules/moment/locale/bn.js",
          "./bo": "./node_modules/moment/locale/bo.js",
          "./bo.js": "./node_modules/moment/locale/bo.js",
          "./br": "./node_modules/moment/locale/br.js",
          "./br.js": "./node_modules/moment/locale/br.js",
          "./bs": "./node_modules/moment/locale/bs.js",
          "./bs.js": "./node_modules/moment/locale/bs.js",
          "./ca": "./node_modules/moment/locale/ca.js",
          "./ca.js": "./node_modules/moment/locale/ca.js",
          "./cs": "./node_modules/moment/locale/cs.js",
          "./cs.js": "./node_modules/moment/locale/cs.js",
          "./cv": "./node_modules/moment/locale/cv.js",
          "./cv.js": "./node_modules/moment/locale/cv.js",
          "./cy": "./node_modules/moment/locale/cy.js",
          "./cy.js": "./node_modules/moment/locale/cy.js",
          "./da": "./node_modules/moment/locale/da.js",
          "./da.js": "./node_modules/moment/locale/da.js",
          "./de": "./node_modules/moment/locale/de.js",
          "./de-at": "./node_modules/moment/locale/de-at.js",
          "./de-at.js": "./node_modules/moment/locale/de-at.js",
          "./de-ch": "./node_modules/moment/locale/de-ch.js",
          "./de-ch.js": "./node_modules/moment/locale/de-ch.js",
          "./de.js": "./node_modules/moment/locale/de.js",
          "./dv": "./node_modules/moment/locale/dv.js",
          "./dv.js": "./node_modules/moment/locale/dv.js",
          "./el": "./node_modules/moment/locale/el.js",
          "./el.js": "./node_modules/moment/locale/el.js",
          "./en-au": "./node_modules/moment/locale/en-au.js",
          "./en-au.js": "./node_modules/moment/locale/en-au.js",
          "./en-ca": "./node_modules/moment/locale/en-ca.js",
          "./en-ca.js": "./node_modules/moment/locale/en-ca.js",
          "./en-gb": "./node_modules/moment/locale/en-gb.js",
          "./en-gb.js": "./node_modules/moment/locale/en-gb.js",
          "./en-ie": "./node_modules/moment/locale/en-ie.js",
          "./en-ie.js": "./node_modules/moment/locale/en-ie.js",
          "./en-il": "./node_modules/moment/locale/en-il.js",
          "./en-il.js": "./node_modules/moment/locale/en-il.js",
          "./en-in": "./node_modules/moment/locale/en-in.js",
          "./en-in.js": "./node_modules/moment/locale/en-in.js",
          "./en-nz": "./node_modules/moment/locale/en-nz.js",
          "./en-nz.js": "./node_modules/moment/locale/en-nz.js",
          "./en-sg": "./node_modules/moment/locale/en-sg.js",
          "./en-sg.js": "./node_modules/moment/locale/en-sg.js",
          "./eo": "./node_modules/moment/locale/eo.js",
          "./eo.js": "./node_modules/moment/locale/eo.js",
          "./es": "./node_modules/moment/locale/es.js",
          "./es-do": "./node_modules/moment/locale/es-do.js",
          "./es-do.js": "./node_modules/moment/locale/es-do.js",
          "./es-us": "./node_modules/moment/locale/es-us.js",
          "./es-us.js": "./node_modules/moment/locale/es-us.js",
          "./es.js": "./node_modules/moment/locale/es.js",
          "./et": "./node_modules/moment/locale/et.js",
          "./et.js": "./node_modules/moment/locale/et.js",
          "./eu": "./node_modules/moment/locale/eu.js",
          "./eu.js": "./node_modules/moment/locale/eu.js",
          "./fa": "./node_modules/moment/locale/fa.js",
          "./fa.js": "./node_modules/moment/locale/fa.js",
          "./fi": "./node_modules/moment/locale/fi.js",
          "./fi.js": "./node_modules/moment/locale/fi.js",
          "./fil": "./node_modules/moment/locale/fil.js",
          "./fil.js": "./node_modules/moment/locale/fil.js",
          "./fo": "./node_modules/moment/locale/fo.js",
          "./fo.js": "./node_modules/moment/locale/fo.js",
          "./fr": "./node_modules/moment/locale/fr.js",
          "./fr-ca": "./node_modules/moment/locale/fr-ca.js",
          "./fr-ca.js": "./node_modules/moment/locale/fr-ca.js",
          "./fr-ch": "./node_modules/moment/locale/fr-ch.js",
          "./fr-ch.js": "./node_modules/moment/locale/fr-ch.js",
          "./fr.js": "./node_modules/moment/locale/fr.js",
          "./fy": "./node_modules/moment/locale/fy.js",
          "./fy.js": "./node_modules/moment/locale/fy.js",
          "./ga": "./node_modules/moment/locale/ga.js",
          "./ga.js": "./node_modules/moment/locale/ga.js",
          "./gd": "./node_modules/moment/locale/gd.js",
          "./gd.js": "./node_modules/moment/locale/gd.js",
          "./gl": "./node_modules/moment/locale/gl.js",
          "./gl.js": "./node_modules/moment/locale/gl.js",
          "./gom-deva": "./node_modules/moment/locale/gom-deva.js",
          "./gom-deva.js": "./node_modules/moment/locale/gom-deva.js",
          "./gom-latn": "./node_modules/moment/locale/gom-latn.js",
          "./gom-latn.js": "./node_modules/moment/locale/gom-latn.js",
          "./gu": "./node_modules/moment/locale/gu.js",
          "./gu.js": "./node_modules/moment/locale/gu.js",
          "./he": "./node_modules/moment/locale/he.js",
          "./he.js": "./node_modules/moment/locale/he.js",
          "./hi": "./node_modules/moment/locale/hi.js",
          "./hi.js": "./node_modules/moment/locale/hi.js",
          "./hr": "./node_modules/moment/locale/hr.js",
          "./hr.js": "./node_modules/moment/locale/hr.js",
          "./hu": "./node_modules/moment/locale/hu.js",
          "./hu.js": "./node_modules/moment/locale/hu.js",
          "./hy-am": "./node_modules/moment/locale/hy-am.js",
          "./hy-am.js": "./node_modules/moment/locale/hy-am.js",
          "./id": "./node_modules/moment/locale/id.js",
          "./id.js": "./node_modules/moment/locale/id.js",
          "./is": "./node_modules/moment/locale/is.js",
          "./is.js": "./node_modules/moment/locale/is.js",
          "./it": "./node_modules/moment/locale/it.js",
          "./it-ch": "./node_modules/moment/locale/it-ch.js",
          "./it-ch.js": "./node_modules/moment/locale/it-ch.js",
          "./it.js": "./node_modules/moment/locale/it.js",
          "./ja": "./node_modules/moment/locale/ja.js",
          "./ja.js": "./node_modules/moment/locale/ja.js",
          "./jv": "./node_modules/moment/locale/jv.js",
          "./jv.js": "./node_modules/moment/locale/jv.js",
          "./ka": "./node_modules/moment/locale/ka.js",
          "./ka.js": "./node_modules/moment/locale/ka.js",
          "./kk": "./node_modules/moment/locale/kk.js",
          "./kk.js": "./node_modules/moment/locale/kk.js",
          "./km": "./node_modules/moment/locale/km.js",
          "./km.js": "./node_modules/moment/locale/km.js",
          "./kn": "./node_modules/moment/locale/kn.js",
          "./kn.js": "./node_modules/moment/locale/kn.js",
          "./ko": "./node_modules/moment/locale/ko.js",
          "./ko.js": "./node_modules/moment/locale/ko.js",
          "./ku": "./node_modules/moment/locale/ku.js",
          "./ku.js": "./node_modules/moment/locale/ku.js",
          "./ky": "./node_modules/moment/locale/ky.js",
          "./ky.js": "./node_modules/moment/locale/ky.js",
          "./lb": "./node_modules/moment/locale/lb.js",
          "./lb.js": "./node_modules/moment/locale/lb.js",
          "./lo": "./node_modules/moment/locale/lo.js",
          "./lo.js": "./node_modules/moment/locale/lo.js",
          "./lt": "./node_modules/moment/locale/lt.js",
          "./lt.js": "./node_modules/moment/locale/lt.js",
          "./lv": "./node_modules/moment/locale/lv.js",
          "./lv.js": "./node_modules/moment/locale/lv.js",
          "./me": "./node_modules/moment/locale/me.js",
          "./me.js": "./node_modules/moment/locale/me.js",
          "./mi": "./node_modules/moment/locale/mi.js",
          "./mi.js": "./node_modules/moment/locale/mi.js",
          "./mk": "./node_modules/moment/locale/mk.js",
          "./mk.js": "./node_modules/moment/locale/mk.js",
          "./ml": "./node_modules/moment/locale/ml.js",
          "./ml.js": "./node_modules/moment/locale/ml.js",
          "./mn": "./node_modules/moment/locale/mn.js",
          "./mn.js": "./node_modules/moment/locale/mn.js",
          "./mr": "./node_modules/moment/locale/mr.js",
          "./mr.js": "./node_modules/moment/locale/mr.js",
          "./ms": "./node_modules/moment/locale/ms.js",
          "./ms-my": "./node_modules/moment/locale/ms-my.js",
          "./ms-my.js": "./node_modules/moment/locale/ms-my.js",
          "./ms.js": "./node_modules/moment/locale/ms.js",
          "./mt": "./node_modules/moment/locale/mt.js",
          "./mt.js": "./node_modules/moment/locale/mt.js",
          "./my": "./node_modules/moment/locale/my.js",
          "./my.js": "./node_modules/moment/locale/my.js",
          "./nb": "./node_modules/moment/locale/nb.js",
          "./nb.js": "./node_modules/moment/locale/nb.js",
          "./ne": "./node_modules/moment/locale/ne.js",
          "./ne.js": "./node_modules/moment/locale/ne.js",
          "./nl": "./node_modules/moment/locale/nl.js",
          "./nl-be": "./node_modules/moment/locale/nl-be.js",
          "./nl-be.js": "./node_modules/moment/locale/nl-be.js",
          "./nl.js": "./node_modules/moment/locale/nl.js",
          "./nn": "./node_modules/moment/locale/nn.js",
          "./nn.js": "./node_modules/moment/locale/nn.js",
          "./oc-lnc": "./node_modules/moment/locale/oc-lnc.js",
          "./oc-lnc.js": "./node_modules/moment/locale/oc-lnc.js",
          "./pa-in": "./node_modules/moment/locale/pa-in.js",
          "./pa-in.js": "./node_modules/moment/locale/pa-in.js",
          "./pl": "./node_modules/moment/locale/pl.js",
          "./pl.js": "./node_modules/moment/locale/pl.js",
          "./pt": "./node_modules/moment/locale/pt.js",
          "./pt-br": "./node_modules/moment/locale/pt-br.js",
          "./pt-br.js": "./node_modules/moment/locale/pt-br.js",
          "./pt.js": "./node_modules/moment/locale/pt.js",
          "./ro": "./node_modules/moment/locale/ro.js",
          "./ro.js": "./node_modules/moment/locale/ro.js",
          "./ru": "./node_modules/moment/locale/ru.js",
          "./ru.js": "./node_modules/moment/locale/ru.js",
          "./sd": "./node_modules/moment/locale/sd.js",
          "./sd.js": "./node_modules/moment/locale/sd.js",
          "./se": "./node_modules/moment/locale/se.js",
          "./se.js": "./node_modules/moment/locale/se.js",
          "./si": "./node_modules/moment/locale/si.js",
          "./si.js": "./node_modules/moment/locale/si.js",
          "./sk": "./node_modules/moment/locale/sk.js",
          "./sk.js": "./node_modules/moment/locale/sk.js",
          "./sl": "./node_modules/moment/locale/sl.js",
          "./sl.js": "./node_modules/moment/locale/sl.js",
          "./sq": "./node_modules/moment/locale/sq.js",
          "./sq.js": "./node_modules/moment/locale/sq.js",
          "./sr": "./node_modules/moment/locale/sr.js",
          "./sr-cyrl": "./node_modules/moment/locale/sr-cyrl.js",
          "./sr-cyrl.js": "./node_modules/moment/locale/sr-cyrl.js",
          "./sr.js": "./node_modules/moment/locale/sr.js",
          "./ss": "./node_modules/moment/locale/ss.js",
          "./ss.js": "./node_modules/moment/locale/ss.js",
          "./sv": "./node_modules/moment/locale/sv.js",
          "./sv.js": "./node_modules/moment/locale/sv.js",
          "./sw": "./node_modules/moment/locale/sw.js",
          "./sw.js": "./node_modules/moment/locale/sw.js",
          "./ta": "./node_modules/moment/locale/ta.js",
          "./ta.js": "./node_modules/moment/locale/ta.js",
          "./te": "./node_modules/moment/locale/te.js",
          "./te.js": "./node_modules/moment/locale/te.js",
          "./tet": "./node_modules/moment/locale/tet.js",
          "./tet.js": "./node_modules/moment/locale/tet.js",
          "./tg": "./node_modules/moment/locale/tg.js",
          "./tg.js": "./node_modules/moment/locale/tg.js",
          "./th": "./node_modules/moment/locale/th.js",
          "./th.js": "./node_modules/moment/locale/th.js",
          "./tl-ph": "./node_modules/moment/locale/tl-ph.js",
          "./tl-ph.js": "./node_modules/moment/locale/tl-ph.js",
          "./tlh": "./node_modules/moment/locale/tlh.js",
          "./tlh.js": "./node_modules/moment/locale/tlh.js",
          "./tr": "./node_modules/moment/locale/tr.js",
          "./tr.js": "./node_modules/moment/locale/tr.js",
          "./tzl": "./node_modules/moment/locale/tzl.js",
          "./tzl.js": "./node_modules/moment/locale/tzl.js",
          "./tzm": "./node_modules/moment/locale/tzm.js",
          "./tzm-latn": "./node_modules/moment/locale/tzm-latn.js",
          "./tzm-latn.js": "./node_modules/moment/locale/tzm-latn.js",
          "./tzm.js": "./node_modules/moment/locale/tzm.js",
          "./ug-cn": "./node_modules/moment/locale/ug-cn.js",
          "./ug-cn.js": "./node_modules/moment/locale/ug-cn.js",
          "./uk": "./node_modules/moment/locale/uk.js",
          "./uk.js": "./node_modules/moment/locale/uk.js",
          "./ur": "./node_modules/moment/locale/ur.js",
          "./ur.js": "./node_modules/moment/locale/ur.js",
          "./uz": "./node_modules/moment/locale/uz.js",
          "./uz-latn": "./node_modules/moment/locale/uz-latn.js",
          "./uz-latn.js": "./node_modules/moment/locale/uz-latn.js",
          "./uz.js": "./node_modules/moment/locale/uz.js",
          "./vi": "./node_modules/moment/locale/vi.js",
          "./vi.js": "./node_modules/moment/locale/vi.js",
          "./x-pseudo": "./node_modules/moment/locale/x-pseudo.js",
          "./x-pseudo.js": "./node_modules/moment/locale/x-pseudo.js",
          "./yo": "./node_modules/moment/locale/yo.js",
          "./yo.js": "./node_modules/moment/locale/yo.js",
          "./zh-cn": "./node_modules/moment/locale/zh-cn.js",
          "./zh-cn.js": "./node_modules/moment/locale/zh-cn.js",
          "./zh-hk": "./node_modules/moment/locale/zh-hk.js",
          "./zh-hk.js": "./node_modules/moment/locale/zh-hk.js",
          "./zh-mo": "./node_modules/moment/locale/zh-mo.js",
          "./zh-mo.js": "./node_modules/moment/locale/zh-mo.js",
          "./zh-tw": "./node_modules/moment/locale/zh-tw.js",
          "./zh-tw.js": "./node_modules/moment/locale/zh-tw.js",
        };

        function webpackContext(req) {
          var id = webpackContextResolve(req);
          return __webpack_require__(id);
        }

        function webpackContextResolve(req) {
          if (!__webpack_require__.o(map, req)) {
            var e = new Error("Cannot find module '" + req + "'");
            e.code = "MODULE_NOT_FOUND";
            throw e;
          }

          return map[req];
        }

        webpackContext.keys = function webpackContextKeys() {
          return Object.keys(map);
        };

        webpackContext.resolve = webpackContextResolve;
        module.exports = webpackContext;
        webpackContext.id =
          "./node_modules/moment/locale sync recursive ^\\.\\/.*$";
        /***/
      },

    /***/
    "./src/app/@core/core.module.ts":
      /*!**************************************!*\
    !*** ./src/app/@core/core.module.ts ***!
    \**************************************/

      /*! exports provided: CoreModule */

      /***/
      function srcAppCoreCoreModuleTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "CoreModule", function () {
          return CoreModule;
        });
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/common */
          "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js"
        );
        /* harmony import */

        var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! @angular/common/http */
          "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js"
        );
        /* harmony import */

        var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! @angular/router */
          "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js"
        );
        /* harmony import */

        var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
          /*! @ngx-translate/core */
          "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js"
        );
        /* harmony import */

        var _route_reusable_strategy__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
          /*! ./route-reusable-strategy */
          "./src/app/@core/route-reusable-strategy.ts"
        );
        /* harmony import */

        var _http_api_prefix_interceptor__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
          /*! ./http/api-prefix.interceptor */
          "./src/app/@core/http/api-prefix.interceptor.ts"
        );
        /* harmony import */

        var _http_error_handler_interceptor__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
          /*! ./http/error-handler.interceptor */
          "./src/app/@core/http/error-handler.interceptor.ts"
        );

        var CoreModule = function CoreModule(parentModule) {
          _classCallCheck(this, CoreModule);

          // Import guard
          if (parentModule) {
            throw new Error(
              "".concat(
                parentModule,
                " has already been loaded. Import Core module in the AppModule only."
              )
            );
          }
        };

        CoreModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineNgModule"
        ]({
          type: CoreModule,
        });
        CoreModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineInjector"
        ]({
          factory: function CoreModule_Factory(t) {
            return new (t || CoreModule)(
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](
                CoreModule,
                12
              )
            );
          },
          providers: [
            {
              provide:
                _angular_common_http__WEBPACK_IMPORTED_MODULE_2__[
                  "HTTP_INTERCEPTORS"
                ],
              useClass:
                _http_api_prefix_interceptor__WEBPACK_IMPORTED_MODULE_6__[
                  "ApiPrefixInterceptor"
                ],
              multi: true,
            },
            {
              provide:
                _angular_common_http__WEBPACK_IMPORTED_MODULE_2__[
                  "HTTP_INTERCEPTORS"
                ],
              useClass:
                _http_error_handler_interceptor__WEBPACK_IMPORTED_MODULE_7__[
                  "ErrorHandlerInterceptor"
                ],
              multi: true,
            },
            {
              provide:
                _angular_router__WEBPACK_IMPORTED_MODULE_3__[
                  "RouteReuseStrategy"
                ],
              useClass:
                _route_reusable_strategy__WEBPACK_IMPORTED_MODULE_5__[
                  "RouteReusableStrategy"
                ],
            },
          ],
          imports: [
            [
              _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
              _angular_common_http__WEBPACK_IMPORTED_MODULE_2__[
                "HttpClientModule"
              ],
              _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__[
                "TranslateModule"
              ],
              _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"],
            ],
          ],
        });

        (function () {
          (typeof ngJitMode === "undefined" || ngJitMode) &&
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](
              CoreModule,
              {
                imports: [
                  _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                  _angular_common_http__WEBPACK_IMPORTED_MODULE_2__[
                    "HttpClientModule"
                  ],
                  _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__[
                    "TranslateModule"
                  ],
                  _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"],
                ],
              }
            );
        })();
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            CoreModule,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
                args: [
                  {
                    imports: [
                      _angular_common__WEBPACK_IMPORTED_MODULE_1__[
                        "CommonModule"
                      ],
                      _angular_common_http__WEBPACK_IMPORTED_MODULE_2__[
                        "HttpClientModule"
                      ],
                      _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__[
                        "TranslateModule"
                      ],
                      _angular_router__WEBPACK_IMPORTED_MODULE_3__[
                        "RouterModule"
                      ],
                    ],
                    providers: [
                      {
                        provide:
                          _angular_common_http__WEBPACK_IMPORTED_MODULE_2__[
                            "HTTP_INTERCEPTORS"
                          ],
                        useClass:
                          _http_api_prefix_interceptor__WEBPACK_IMPORTED_MODULE_6__[
                            "ApiPrefixInterceptor"
                          ],
                        multi: true,
                      },
                      {
                        provide:
                          _angular_common_http__WEBPACK_IMPORTED_MODULE_2__[
                            "HTTP_INTERCEPTORS"
                          ],
                        useClass:
                          _http_error_handler_interceptor__WEBPACK_IMPORTED_MODULE_7__[
                            "ErrorHandlerInterceptor"
                          ],
                        multi: true,
                      },
                      {
                        provide:
                          _angular_router__WEBPACK_IMPORTED_MODULE_3__[
                            "RouteReuseStrategy"
                          ],
                        useClass:
                          _route_reusable_strategy__WEBPACK_IMPORTED_MODULE_5__[
                            "RouteReusableStrategy"
                          ],
                      },
                    ],
                  },
                ],
              },
            ],
            function () {
              return [
                {
                  type: CoreModule,
                  decorators: [
                    {
                      type:
                        _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"],
                    },
                    {
                      type:
                        _angular_core__WEBPACK_IMPORTED_MODULE_0__["SkipSelf"],
                    },
                  ],
                },
              ];
            },
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/@core/http/api-prefix.interceptor.ts":
      /*!******************************************************!*\
    !*** ./src/app/@core/http/api-prefix.interceptor.ts ***!
    \******************************************************/

      /*! exports provided: ApiPrefixInterceptor */

      /***/
      function srcAppCoreHttpApiPrefixInterceptorTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "ApiPrefixInterceptor",
          function () {
            return ApiPrefixInterceptor;
          }
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _env_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @env/environment */
          "./src/environments/environment.ts"
        );
        /**
         * Prefixes all requests not starting with `http[s]` with `environment.serverUrl`.
         */

        var ApiPrefixInterceptor = /*#__PURE__*/ (function () {
          function ApiPrefixInterceptor() {
            _classCallCheck(this, ApiPrefixInterceptor);
          }

          _createClass(ApiPrefixInterceptor, [
            {
              key: "intercept",
              value: function intercept(request, next) {
                if (!/^(http|https):/i.test(request.url)) {
                  request = request.clone({
                    url:
                      _env_environment__WEBPACK_IMPORTED_MODULE_1__[
                        "environment"
                      ].serverUrl + request.url,
                  });
                }

                return next.handle(request);
              },
            },
          ]);

          return ApiPrefixInterceptor;
        })();

        ApiPrefixInterceptor.ɵfac = function ApiPrefixInterceptor_Factory(t) {
          return new (t || ApiPrefixInterceptor)();
        };

        ApiPrefixInterceptor.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineInjectable"
        ]({
          token: ApiPrefixInterceptor,
          factory: ApiPrefixInterceptor.ɵfac,
          providedIn: "root",
        });
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            ApiPrefixInterceptor,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
                args: [
                  {
                    providedIn: "root",
                  },
                ],
              },
            ],
            null,
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/@core/http/error-handler.interceptor.ts":
      /*!*********************************************************!*\
    !*** ./src/app/@core/http/error-handler.interceptor.ts ***!
    \*********************************************************/

      /*! exports provided: ErrorHandlerInterceptor */

      /***/
      function srcAppCoreHttpErrorHandlerInterceptorTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "ErrorHandlerInterceptor",
          function () {
            return ErrorHandlerInterceptor;
          }
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! rxjs/operators */
          "./node_modules/rxjs/_esm2015/operators/index.js"
        );
        /* harmony import */

        var _env_environment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! @env/environment */
          "./src/environments/environment.ts"
        );
        /* harmony import */

        var _logger_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! ../logger.service */
          "./src/app/@core/logger.service.ts"
        );

        var log = new _logger_service__WEBPACK_IMPORTED_MODULE_3__["Logger"](
          "ErrorHandlerInterceptor"
        );
        /**
         * Adds a default error handler to all requests.
         */

        var ErrorHandlerInterceptor = /*#__PURE__*/ (function () {
          function ErrorHandlerInterceptor() {
            _classCallCheck(this, ErrorHandlerInterceptor);
          }

          _createClass(ErrorHandlerInterceptor, [
            {
              key: "intercept",
              value: function intercept(request, next) {
                var _this = this;

                return next.handle(request).pipe(
                  Object(
                    rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"]
                  )(function (error) {
                    return _this.errorHandler(error);
                  })
                );
              }, // Customize the default error handler here if needed
            },
            {
              key: "errorHandler",
              value: function errorHandler(response) {
                if (
                  !_env_environment__WEBPACK_IMPORTED_MODULE_2__["environment"]
                    .production
                ) {
                  // Do something with the error
                  log.error("Request error", response);
                }

                throw response;
              },
            },
          ]);

          return ErrorHandlerInterceptor;
        })();

        ErrorHandlerInterceptor.ɵfac = function ErrorHandlerInterceptor_Factory(
          t
        ) {
          return new (t || ErrorHandlerInterceptor)();
        };

        ErrorHandlerInterceptor.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineInjectable"
        ]({
          token: ErrorHandlerInterceptor,
          factory: ErrorHandlerInterceptor.ɵfac,
          providedIn: "root",
        });
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            ErrorHandlerInterceptor,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
                args: [
                  {
                    providedIn: "root",
                  },
                ],
              },
            ],
            null,
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/@core/index.ts":
      /*!********************************!*\
    !*** ./src/app/@core/index.ts ***!
    \********************************/

      /*! exports provided: CoreModule, ApiPrefixInterceptor, ErrorHandlerInterceptor, RouteReusableStrategy, LogLevel, Logger, untilDestroyed */

      /***/
      function srcAppCoreIndexTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony import */

        var _core_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! ./core.module */
          "./src/app/@core/core.module.ts"
        );
        /* harmony reexport (safe) */

        __webpack_require__.d(__webpack_exports__, "CoreModule", function () {
          return _core_module__WEBPACK_IMPORTED_MODULE_0__["CoreModule"];
        });
        /* harmony import */

        var _http_api_prefix_interceptor__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! ./http/api-prefix.interceptor */
          "./src/app/@core/http/api-prefix.interceptor.ts"
        );
        /* harmony reexport (safe) */

        __webpack_require__.d(
          __webpack_exports__,
          "ApiPrefixInterceptor",
          function () {
            return _http_api_prefix_interceptor__WEBPACK_IMPORTED_MODULE_1__[
              "ApiPrefixInterceptor"
            ];
          }
        );
        /* harmony import */

        var _http_error_handler_interceptor__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! ./http/error-handler.interceptor */
          "./src/app/@core/http/error-handler.interceptor.ts"
        );
        /* harmony reexport (safe) */

        __webpack_require__.d(
          __webpack_exports__,
          "ErrorHandlerInterceptor",
          function () {
            return _http_error_handler_interceptor__WEBPACK_IMPORTED_MODULE_2__[
              "ErrorHandlerInterceptor"
            ];
          }
        );
        /* harmony import */

        var _route_reusable_strategy__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! ./route-reusable-strategy */
          "./src/app/@core/route-reusable-strategy.ts"
        );
        /* harmony reexport (safe) */

        __webpack_require__.d(
          __webpack_exports__,
          "RouteReusableStrategy",
          function () {
            return _route_reusable_strategy__WEBPACK_IMPORTED_MODULE_3__[
              "RouteReusableStrategy"
            ];
          }
        );
        /* harmony import */

        var _logger_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
          /*! ./logger.service */
          "./src/app/@core/logger.service.ts"
        );
        /* harmony reexport (safe) */

        __webpack_require__.d(__webpack_exports__, "LogLevel", function () {
          return _logger_service__WEBPACK_IMPORTED_MODULE_4__["LogLevel"];
        });
        /* harmony reexport (safe) */

        __webpack_require__.d(__webpack_exports__, "Logger", function () {
          return _logger_service__WEBPACK_IMPORTED_MODULE_4__["Logger"];
        });
        /* harmony import */

        var _until_destroyed__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
          /*! ./until-destroyed */
          "./src/app/@core/until-destroyed.ts"
        );
        /* harmony reexport (safe) */

        __webpack_require__.d(
          __webpack_exports__,
          "untilDestroyed",
          function () {
            return _until_destroyed__WEBPACK_IMPORTED_MODULE_5__[
              "untilDestroyed"
            ];
          }
        );
        /***/
      },

    /***/
    "./src/app/@core/logger.service.ts":
      /*!*****************************************!*\
    !*** ./src/app/@core/logger.service.ts ***!
    \*****************************************/

      /*! exports provided: LogLevel, Logger */

      /***/
      function srcAppCoreLoggerServiceTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "LogLevel", function () {
          return LogLevel;
        });
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "Logger", function () {
          return Logger;
        });
        /**
         * Simple logger system with the possibility of registering custom outputs.
         *
         * 4 different log levels are provided, with corresponding methods:
         * - debug   : for debug information
         * - info    : for informative status of the application (success, ...)
         * - warning : for non-critical errors that do not prevent normal application behavior
         * - error   : for critical errors that prevent normal application behavior
         *
         * Example usage:
         * ```
         * import { Logger } from 'app/core/logger.service';
         *
         * const log = new Logger('myFile');
         * ...
         * log.debug('something happened');
         * ```
         *
         * To disable debug and info logs in production, add this snippet to your root component:
         * ```
         * export class AppComponent implements OnInit {
         *   ngOnInit() {
         *     if (environment.production) {
         *       Logger.enableProductionMode();
         *     }
         *     ...
         *   }
         * }
         *
         * If you want to process logs through other outputs than console, you can add LogOutput functions to Logger.outputs.
         */

        /**
         * The possible log levels.
         * LogLevel.Off is never emitted and only used with Logger.level property to disable logs.
         */

        var LogLevel;

        (function (LogLevel) {
          LogLevel[(LogLevel["Off"] = 0)] = "Off";
          LogLevel[(LogLevel["Error"] = 1)] = "Error";
          LogLevel[(LogLevel["Warning"] = 2)] = "Warning";
          LogLevel[(LogLevel["Info"] = 3)] = "Info";
          LogLevel[(LogLevel["Debug"] = 4)] = "Debug";
        })(LogLevel || (LogLevel = {}));

        var Logger = /*#__PURE__*/ (function () {
          function Logger(source) {
            _classCallCheck(this, Logger);

            this.source = source;
          }
          /**
           * Enables production mode.
           * Sets logging level to LogLevel.Warning.
           */

          _createClass(
            Logger,
            [
              {
                key: "debug",

                /**
                 * Logs messages or objects  with the debug level.
                 * Works the same as console.log().
                 */
                value: function debug() {
                  for (
                    var _len = arguments.length,
                      objects = new Array(_len),
                      _key = 0;
                    _key < _len;
                    _key++
                  ) {
                    objects[_key] = arguments[_key];
                  }

                  this.log(console.log, LogLevel.Debug, objects);
                },
                /**
                 * Logs messages or objects  with the info level.
                 * Works the same as console.log().
                 */
              },
              {
                key: "info",
                value: function info() {
                  for (
                    var _len2 = arguments.length,
                      objects = new Array(_len2),
                      _key2 = 0;
                    _key2 < _len2;
                    _key2++
                  ) {
                    objects[_key2] = arguments[_key2];
                  }

                  this.log(console.info, LogLevel.Info, objects);
                },
                /**
                 * Logs messages or objects  with the warning level.
                 * Works the same as console.log().
                 */
              },
              {
                key: "warn",
                value: function warn() {
                  for (
                    var _len3 = arguments.length,
                      objects = new Array(_len3),
                      _key3 = 0;
                    _key3 < _len3;
                    _key3++
                  ) {
                    objects[_key3] = arguments[_key3];
                  }

                  this.log(console.warn, LogLevel.Warning, objects);
                },
                /**
                 * Logs messages or objects  with the error level.
                 * Works the same as console.log().
                 */
              },
              {
                key: "error",
                value: function error() {
                  for (
                    var _len4 = arguments.length,
                      objects = new Array(_len4),
                      _key4 = 0;
                    _key4 < _len4;
                    _key4++
                  ) {
                    objects[_key4] = arguments[_key4];
                  }

                  this.log(console.error, LogLevel.Error, objects);
                },
              },
              {
                key: "log",
                value: function log(func, level, objects) {
                  var _this2 = this;

                  if (level <= Logger.level) {
                    var log = this.source
                      ? ["[" + this.source + "]"].concat(objects)
                      : objects;
                    func.apply(console, log);
                    Logger.outputs.forEach(function (output) {
                      return output.apply(
                        output,
                        [_this2.source, level].concat(
                          _toConsumableArray(objects)
                        )
                      );
                    });
                  }
                },
              },
            ],
            [
              {
                key: "enableProductionMode",
                value: function enableProductionMode() {
                  Logger.level = LogLevel.Warning;
                },
              },
            ]
          );

          return Logger;
        })();
        /**
         * Current logging level.
         * Set it to LogLevel.Off to disable logs completely.
         */

        Logger.level = LogLevel.Debug;
        /**
         * Additional log outputs.
         */

        Logger.outputs = [];
        /***/
      },

    /***/
    "./src/app/@core/route-reusable-strategy.ts":
      /*!**************************************************!*\
    !*** ./src/app/@core/route-reusable-strategy.ts ***!
    \**************************************************/

      /*! exports provided: RouteReusableStrategy */

      /***/
      function srcAppCoreRouteReusableStrategyTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "RouteReusableStrategy",
          function () {
            return RouteReusableStrategy;
          }
        );
        /* harmony import */

        var _angular_router__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/router */
          "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js"
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /**
         * A route strategy allowing for explicit route reuse.
         * Used as a workaround for https://github.com/angular/angular/issues/18374
         * To reuse a given route, add `data: { reuse: true }` to the route definition.
         */

        var RouteReusableStrategy = /*#__PURE__*/ (function (
          _angular_router__WEBP
        ) {
          _inherits(RouteReusableStrategy, _angular_router__WEBP);

          var _super = _createSuper(RouteReusableStrategy);

          function RouteReusableStrategy() {
            _classCallCheck(this, RouteReusableStrategy);

            return _super.apply(this, arguments);
          }

          _createClass(RouteReusableStrategy, [
            {
              key: "shouldDetach",
              value: function shouldDetach(route) {
                return false;
              },
            },
            {
              key: "store",
              value: function store(route, detachedTree) {},
            },
            {
              key: "shouldAttach",
              value: function shouldAttach(route) {
                return false;
              },
            },
            {
              key: "retrieve",
              value: function retrieve(route) {
                return null;
              },
            },
            {
              key: "shouldReuseRoute",
              value: function shouldReuseRoute(future, curr) {
                return (
                  future.routeConfig === curr.routeConfig || future.data.reuse
                );
              },
            },
          ]);

          return RouteReusableStrategy;
        })(_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouteReuseStrategy"]);

        RouteReusableStrategy.ɵfac = function RouteReusableStrategy_Factory(t) {
          return ɵRouteReusableStrategy_BaseFactory(t || RouteReusableStrategy);
        };

        RouteReusableStrategy.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_1__[
          "ɵɵdefineInjectable"
        ]({
          token: RouteReusableStrategy,
          factory: RouteReusableStrategy.ɵfac,
        });

        var ɵRouteReusableStrategy_BaseFactory = _angular_core__WEBPACK_IMPORTED_MODULE_1__[
          "ɵɵgetInheritedFactory"
        ](RouteReusableStrategy);
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵsetClassMetadata"](
            RouteReusableStrategy,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"],
              },
            ],
            null,
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/@core/until-destroyed.ts":
      /*!******************************************!*\
    !*** ./src/app/@core/until-destroyed.ts ***!
    \******************************************/

      /*! exports provided: untilDestroyed */

      /***/
      function srcAppCoreUntilDestroyedTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "untilDestroyed",
          function () {
            return untilDestroyed;
          }
        );
        /* harmony import */

        var rxjs__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! rxjs */
          "./node_modules/rxjs/_esm2015/index.js"
        );
        /* harmony import */

        var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! rxjs/operators */
          "./node_modules/rxjs/_esm2015/operators/index.js"
        );

        var untilDestroyedSymbol = Symbol("untilDestroyed");
        /**
         * RxJS operator that unsubscribe from observables on destory.
         * Code forked from https://github.com/NetanelBasal/ngx-take-until-destroy
         *
         * IMPORTANT: Add the `untilDestroyed` operator as the last one to prevent leaks with intermediate observables in the
         * operator chain.
         *
         * @param instance The parent Angular component or object instance.
         * @param destroyMethodName The method to hook on (default: 'ngOnDestroy').
         * @example
         * ```
         * import { untilDestroyed } from '@core';
         *
         * @Component({
         * selector: 'app-example',
         *   templateUrl: './example.component.html'
         * })
         * export class ExampleComponent implements OnInit, OnDestroy {
         *   ngOnInit() {
         *     interval(1000)
         *       .pipe(untilDestroyed(this))
         *       .subscribe(val => console.log(val));
         *   }
         *
         *   // This method must be present, even if empty.
         *   ngOnDestroy() {
         *     // To protect you, an error will be thrown if it doesn't exist.
         *   }
         * }
         * ```
         */

        function untilDestroyed(instance) {
          var destroyMethodName =
            arguments.length > 1 && arguments[1] !== undefined
              ? arguments[1]
              : "ngOnDestroy";
          return function (source) {
            var originalDestroy = instance[destroyMethodName];
            var hasDestroyFunction = typeof originalDestroy === "function";

            if (!hasDestroyFunction) {
              throw new Error(
                ""
                  .concat(
                    instance.constructor.name,
                    " is using untilDestroyed but doesn't implement "
                  )
                  .concat(destroyMethodName)
              );
            }

            if (!instance[untilDestroyedSymbol]) {
              instance[
                untilDestroyedSymbol
              ] = new rxjs__WEBPACK_IMPORTED_MODULE_0__["Subject"]();

              instance[destroyMethodName] = function () {
                if (hasDestroyFunction) {
                  originalDestroy.apply(this, arguments);
                }

                instance[untilDestroyedSymbol].next();
                instance[untilDestroyedSymbol].complete();
              };
            }

            return source.pipe(
              Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeUntil"])(
                instance[untilDestroyedSymbol]
              )
            );
          };
        }
        /***/
      },

    /***/
    "./src/app/@shared/index.ts":
      /*!**********************************!*\
    !*** ./src/app/@shared/index.ts ***!
    \**********************************/

      /*! exports provided: SharedModule, LoaderComponent */

      /***/
      function srcAppSharedIndexTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony import */

        var _shared_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! ./shared.module */
          "./src/app/@shared/shared.module.ts"
        );
        /* harmony reexport (safe) */

        __webpack_require__.d(__webpack_exports__, "SharedModule", function () {
          return _shared_module__WEBPACK_IMPORTED_MODULE_0__["SharedModule"];
        });
        /* harmony import */

        var _loader_loader_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! ./loader/loader.component */
          "./src/app/@shared/loader/loader.component.ts"
        );
        /* harmony reexport (safe) */

        __webpack_require__.d(
          __webpack_exports__,
          "LoaderComponent",
          function () {
            return _loader_loader_component__WEBPACK_IMPORTED_MODULE_1__[
              "LoaderComponent"
            ];
          }
        );
        /***/
      },

    /***/
    "./src/app/@shared/loader/loader.component.ts":
      /*!****************************************************!*\
    !*** ./src/app/@shared/loader/loader.component.ts ***!
    \****************************************************/

      /*! exports provided: LoaderComponent */

      /***/
      function srcAppSharedLoaderLoaderComponentTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "LoaderComponent",
          function () {
            return LoaderComponent;
          }
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );

        var LoaderComponent = /*#__PURE__*/ (function () {
          function LoaderComponent() {
            _classCallCheck(this, LoaderComponent);

            this.isLoading = false;
          }

          _createClass(LoaderComponent, [
            {
              key: "ngOnInit",
              value: function ngOnInit() {},
            },
          ]);

          return LoaderComponent;
        })();

        LoaderComponent.ɵfac = function LoaderComponent_Factory(t) {
          return new (t || LoaderComponent)();
        };

        LoaderComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineComponent"
        ]({
          type: LoaderComponent,
          selectors: [["app-loader"]],
          inputs: {
            isLoading: "isLoading",
            message: "message",
          },
          decls: 8,
          vars: 2,
          consts: [
            [1, "text-xs-center", 3, "hidden"],
            [1, "fas", "fa-cog", "fa-spin", "fa-3x"],
          ],
          template: function LoaderComponent_Template(rf, ctx) {
            if (rf & 1) {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                0,
                "div",
                0
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](
                2,
                "i",
                1
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, " ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                4,
                "span"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "\n");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "\n");
            }

            if (rf & 2) {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
                "hidden",
                !ctx.isLoading
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](
                ctx.message
              );
            }
          },
          styles: [
            ".fa[_ngcontent-%COMP%] {\n  vertical-align: middle;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9Vc2Vycy9uaWtvc2tvdXMvTm9TUUwtT3BlcmF0b3JzL25vZGEtdmlzdWFsaXphdGlvbi9zcmMvbWFpbi91aS9zcmMvYXBwL0BzaGFyZWQvbG9hZGVyL2xvYWRlci5jb21wb25lbnQuc2NzcyIsInNyYy9hcHAvQHNoYXJlZC9sb2FkZXIvbG9hZGVyLmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usc0JBQUE7QUNDRiIsImZpbGUiOiJzcmMvYXBwL0BzaGFyZWQvbG9hZGVyL2xvYWRlci5jb21wb25lbnQuc2NzcyIsInNvdXJjZXNDb250ZW50IjpbIi5mYSB7XG4gIHZlcnRpY2FsLWFsaWduOiBtaWRkbGU7XG59XG4iLCIuZmEge1xuICB2ZXJ0aWNhbC1hbGlnbjogbWlkZGxlO1xufSJdfQ== */",
          ],
        });
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            LoaderComponent,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
                args: [
                  {
                    selector: "app-loader",
                    templateUrl: "./loader.component.html",
                    styleUrls: ["./loader.component.scss"],
                  },
                ],
              },
            ],
            function () {
              return [];
            },
            {
              isLoading: [
                {
                  type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
                },
              ],
              message: [
                {
                  type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
                },
              ],
            }
          );
        })();
        /***/
      },

    /***/
    "./src/app/@shared/shared.module.ts":
      /*!******************************************!*\
    !*** ./src/app/@shared/shared.module.ts ***!
    \******************************************/

      /*! exports provided: SharedModule */

      /***/
      function srcAppSharedSharedModuleTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "SharedModule", function () {
          return SharedModule;
        });
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/common */
          "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js"
        );
        /* harmony import */

        var _loader_loader_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! ./loader/loader.component */
          "./src/app/@shared/loader/loader.component.ts"
        );

        var SharedModule = function SharedModule() {
          _classCallCheck(this, SharedModule);
        };

        SharedModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineNgModule"
        ]({
          type: SharedModule,
        });
        SharedModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineInjector"
        ]({
          factory: function SharedModule_Factory(t) {
            return new (t || SharedModule)();
          },
          imports: [
            [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"]],
          ],
        });

        (function () {
          (typeof ngJitMode === "undefined" || ngJitMode) &&
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](
              SharedModule,
              {
                declarations: [
                  _loader_loader_component__WEBPACK_IMPORTED_MODULE_2__[
                    "LoaderComponent"
                  ],
                ],
                imports: [
                  _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                ],
                exports: [
                  _loader_loader_component__WEBPACK_IMPORTED_MODULE_2__[
                    "LoaderComponent"
                  ],
                ],
              }
            );
        })();
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            SharedModule,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
                args: [
                  {
                    imports: [
                      _angular_common__WEBPACK_IMPORTED_MODULE_1__[
                        "CommonModule"
                      ],
                    ],
                    declarations: [
                      _loader_loader_component__WEBPACK_IMPORTED_MODULE_2__[
                        "LoaderComponent"
                      ],
                    ],
                    exports: [
                      _loader_loader_component__WEBPACK_IMPORTED_MODULE_2__[
                        "LoaderComponent"
                      ],
                    ],
                  },
                ],
              },
            ],
            null,
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/about/about-routing.module.ts":
      /*!***********************************************!*\
    !*** ./src/app/about/about-routing.module.ts ***!
    \***********************************************/

      /*! exports provided: AboutRoutingModule */

      /***/
      function srcAppAboutAboutRoutingModuleTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "AboutRoutingModule",
          function () {
            return AboutRoutingModule;
          }
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/router */
          "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js"
        );
        /* harmony import */

        var _app_i18n__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! @app/i18n */
          "./src/app/i18n/index.ts"
        );
        /* harmony import */

        var _app_shell_shell_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! @app/shell/shell.service */
          "./src/app/shell/shell.service.ts"
        );
        /* harmony import */

        var _about_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
          /*! ./about.component */
          "./src/app/about/about.component.ts"
        );

        var routes = [
          _app_shell_shell_service__WEBPACK_IMPORTED_MODULE_3__[
            "Shell"
          ].childRoutes([
            {
              path: "about",
              component:
                _about_component__WEBPACK_IMPORTED_MODULE_4__["AboutComponent"],
              data: {
                title: Object(
                  _app_i18n__WEBPACK_IMPORTED_MODULE_2__["extract"]
                )("About"),
              },
            },
          ]),
        ];

        var AboutRoutingModule = function AboutRoutingModule() {
          _classCallCheck(this, AboutRoutingModule);
        };

        AboutRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineNgModule"
        ]({
          type: AboutRoutingModule,
        });
        AboutRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineInjector"
        ]({
          factory: function AboutRoutingModule_Factory(t) {
            return new (t || AboutRoutingModule)();
          },
          providers: [],
          imports: [
            [
              _angular_router__WEBPACK_IMPORTED_MODULE_1__[
                "RouterModule"
              ].forChild(routes),
            ],
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"],
          ],
        });

        (function () {
          (typeof ngJitMode === "undefined" || ngJitMode) &&
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](
              AboutRoutingModule,
              {
                imports: [
                  _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"],
                ],
                exports: [
                  _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"],
                ],
              }
            );
        })();
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            AboutRoutingModule,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
                args: [
                  {
                    imports: [
                      _angular_router__WEBPACK_IMPORTED_MODULE_1__[
                        "RouterModule"
                      ].forChild(routes),
                    ],
                    exports: [
                      _angular_router__WEBPACK_IMPORTED_MODULE_1__[
                        "RouterModule"
                      ],
                    ],
                    providers: [],
                  },
                ],
              },
            ],
            null,
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/about/about.component.ts":
      /*!******************************************!*\
    !*** ./src/app/about/about.component.ts ***!
    \******************************************/

      /*! exports provided: AboutComponent */

      /***/
      function srcAppAboutAboutComponentTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "AboutComponent",
          function () {
            return AboutComponent;
          }
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _env_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @env/environment */
          "./src/environments/environment.ts"
        );
        /* harmony import */

        var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! @ngx-translate/core */
          "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js"
        );

        var AboutComponent = /*#__PURE__*/ (function () {
          function AboutComponent() {
            _classCallCheck(this, AboutComponent);

            this.version =
              _env_environment__WEBPACK_IMPORTED_MODULE_1__[
                "environment"
              ].version;
          }

          _createClass(AboutComponent, [
            {
              key: "ngOnInit",
              value: function ngOnInit() {},
            },
          ]);

          return AboutComponent;
        })();

        AboutComponent.ɵfac = function AboutComponent_Factory(t) {
          return new (t || AboutComponent)();
        };

        AboutComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineComponent"
        ]({
          type: AboutComponent,
          selectors: [["app-about"]],
          decls: 20,
          vars: 1,
          consts: [
            [1, "container-fluid"],
            [1, "jumbotron", "text-center"],
            ["translate", ""],
            [1, "far", "fa-bookmark"],
          ],
          template: function AboutComponent_Template(rf, ctx) {
            if (rf & 1) {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                0,
                "div",
                0
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                2,
                "div",
                1
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, "\n    ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                4,
                "h1"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                5,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                6,
                "span",
                2
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                7,
                "APP_NAME"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "\n    ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "\n    ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                10,
                "p"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                11,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](
                12,
                "i",
                3
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13, " ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                14,
                "span",
                2
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                15,
                "Version"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](17, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18, "\n");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](19, "\n");
            }

            if (rf & 2) {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](16);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](
                "\n      ",
                ctx.version,
                "\n    "
              );
            }
          },
          directives: [
            _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
              "TranslateDirective"
            ],
          ],
          styles: [
            "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2Fib3V0L2Fib3V0LmNvbXBvbmVudC5zY3NzIn0= */",
          ],
        });
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            AboutComponent,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
                args: [
                  {
                    selector: "app-about",
                    templateUrl: "./about.component.html",
                    styleUrls: ["./about.component.scss"],
                  },
                ],
              },
            ],
            function () {
              return [];
            },
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/about/about.module.ts":
      /*!***************************************!*\
    !*** ./src/app/about/about.module.ts ***!
    \***************************************/

      /*! exports provided: AboutModule */

      /***/
      function srcAppAboutAboutModuleTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "AboutModule", function () {
          return AboutModule;
        });
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/common */
          "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js"
        );
        /* harmony import */

        var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! @ngx-translate/core */
          "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js"
        );
        /* harmony import */

        var _about_routing_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! ./about-routing.module */
          "./src/app/about/about-routing.module.ts"
        );
        /* harmony import */

        var _about_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
          /*! ./about.component */
          "./src/app/about/about.component.ts"
        );

        var AboutModule = function AboutModule() {
          _classCallCheck(this, AboutModule);
        };

        AboutModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineNgModule"
        ]({
          type: AboutModule,
        });
        AboutModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineInjector"
        ]({
          factory: function AboutModule_Factory(t) {
            return new (t || AboutModule)();
          },
          imports: [
            [
              _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
              _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
                "TranslateModule"
              ],
              _about_routing_module__WEBPACK_IMPORTED_MODULE_3__[
                "AboutRoutingModule"
              ],
            ],
          ],
        });

        (function () {
          (typeof ngJitMode === "undefined" || ngJitMode) &&
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](
              AboutModule,
              {
                declarations: [
                  _about_component__WEBPACK_IMPORTED_MODULE_4__[
                    "AboutComponent"
                  ],
                ],
                imports: [
                  _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                  _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
                    "TranslateModule"
                  ],
                  _about_routing_module__WEBPACK_IMPORTED_MODULE_3__[
                    "AboutRoutingModule"
                  ],
                ],
              }
            );
        })();
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            AboutModule,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
                args: [
                  {
                    imports: [
                      _angular_common__WEBPACK_IMPORTED_MODULE_1__[
                        "CommonModule"
                      ],
                      _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
                        "TranslateModule"
                      ],
                      _about_routing_module__WEBPACK_IMPORTED_MODULE_3__[
                        "AboutRoutingModule"
                      ],
                    ],
                    declarations: [
                      _about_component__WEBPACK_IMPORTED_MODULE_4__[
                        "AboutComponent"
                      ],
                    ],
                  },
                ],
              },
            ],
            null,
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/app-routing.module.ts":
      /*!***************************************!*\
    !*** ./src/app/app-routing.module.ts ***!
    \***************************************/

      /*! exports provided: AppRoutingModule */

      /***/
      function srcAppAppRoutingModuleTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "AppRoutingModule",
          function () {
            return AppRoutingModule;
          }
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/router */
          "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js"
        );

        var routes = [
          // Fallback when no prior route is matched
          {
            path: "**",
            redirectTo: "",
            pathMatch: "full",
          },
        ];

        var AppRoutingModule = function AppRoutingModule() {
          _classCallCheck(this, AppRoutingModule);
        };

        AppRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineNgModule"
        ]({
          type: AppRoutingModule,
        });
        AppRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineInjector"
        ]({
          factory: function AppRoutingModule_Factory(t) {
            return new (t || AppRoutingModule)();
          },
          providers: [],
          imports: [
            [
              _angular_router__WEBPACK_IMPORTED_MODULE_1__[
                "RouterModule"
              ].forRoot(routes),
            ],
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"],
          ],
        });

        (function () {
          (typeof ngJitMode === "undefined" || ngJitMode) &&
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](
              AppRoutingModule,
              {
                imports: [
                  _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"],
                ],
                exports: [
                  _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"],
                ],
              }
            );
        })();
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            AppRoutingModule,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
                args: [
                  {
                    imports: [
                      _angular_router__WEBPACK_IMPORTED_MODULE_1__[
                        "RouterModule"
                      ].forRoot(routes),
                    ],
                    exports: [
                      _angular_router__WEBPACK_IMPORTED_MODULE_1__[
                        "RouterModule"
                      ],
                    ],
                    providers: [],
                  },
                ],
              },
            ],
            null,
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/app.component.ts":
      /*!**********************************!*\
    !*** ./src/app/app.component.ts ***!
    \**********************************/

      /*! exports provided: AppComponent */

      /***/
      function srcAppAppComponentTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "AppComponent", function () {
          return AppComponent;
        });
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/router */
          "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js"
        );
        /* harmony import */

        var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! @angular/platform-browser */
          "./node_modules/@angular/platform-browser/__ivy_ngcc__/fesm2015/platform-browser.js"
        );
        /* harmony import */

        var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! @ngx-translate/core */
          "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js"
        );
        /* harmony import */

        var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
          /*! rxjs */
          "./node_modules/rxjs/_esm2015/index.js"
        );
        /* harmony import */

        var rxjs_operators__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
          /*! rxjs/operators */
          "./node_modules/rxjs/_esm2015/operators/index.js"
        );
        /* harmony import */

        var _env_environment__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
          /*! @env/environment */
          "./src/environments/environment.ts"
        );
        /* harmony import */

        var _core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
          /*! @core */
          "./src/app/@core/index.ts"
        );
        /* harmony import */

        var _app_i18n__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(
          /*! @app/i18n */
          "./src/app/i18n/index.ts"
        );

        var log = new _core__WEBPACK_IMPORTED_MODULE_7__["Logger"]("App");

        var AppComponent = /*#__PURE__*/ (function () {
          function AppComponent(
            router,
            activatedRoute,
            titleService,
            translateService,
            i18nService
          ) {
            _classCallCheck(this, AppComponent);

            this.router = router;
            this.activatedRoute = activatedRoute;
            this.titleService = titleService;
            this.translateService = translateService;
            this.i18nService = i18nService;
          }

          _createClass(AppComponent, [
            {
              key: "ngOnInit",
              value: function ngOnInit() {
                var _this3 = this;

                // Setup logger
                if (
                  _env_environment__WEBPACK_IMPORTED_MODULE_6__["environment"]
                    .production
                ) {
                  _core__WEBPACK_IMPORTED_MODULE_7__[
                    "Logger"
                  ].enableProductionMode();
                }

                log.debug("init"); // Setup translations

                this.i18nService.init(
                  _env_environment__WEBPACK_IMPORTED_MODULE_6__["environment"]
                    .defaultLanguage,
                  _env_environment__WEBPACK_IMPORTED_MODULE_6__["environment"]
                    .supportedLanguages
                );
                var onNavigationEnd = this.router.events.pipe(
                  Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["filter"])(
                    function (event) {
                      return (
                        event instanceof
                        _angular_router__WEBPACK_IMPORTED_MODULE_1__[
                          "NavigationEnd"
                        ]
                      );
                    }
                  )
                ); // Change page title on navigation or language change, based on route data

                Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["merge"])(
                  this.translateService.onLangChange,
                  onNavigationEnd
                )
                  .pipe(
                    Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["map"])(
                      function () {
                        var route = _this3.activatedRoute;

                        while (route.firstChild) {
                          route = route.firstChild;
                        }

                        return route;
                      }
                    ),
                    Object(
                      rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["filter"]
                    )(function (route) {
                      return route.outlet === "primary";
                    }),
                    Object(
                      rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["switchMap"]
                    )(function (route) {
                      return route.data;
                    }),
                    Object(
                      _core__WEBPACK_IMPORTED_MODULE_7__["untilDestroyed"]
                    )(this)
                  )
                  .subscribe(function (event) {
                    var title = event.title;

                    if (title) {
                      _this3.titleService.setTitle(
                        _this3.translateService.instant(title)
                      );
                    }
                  });
              },
            },
            {
              key: "ngOnDestroy",
              value: function ngOnDestroy() {
                this.i18nService.destroy();
              },
            },
          ]);

          return AppComponent;
        })();

        AppComponent.ɵfac = function AppComponent_Factory(t) {
          return new (t || AppComponent)(
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](
              _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]
            ),
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](
              _angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"]
            ),
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](
              _angular_platform_browser__WEBPACK_IMPORTED_MODULE_2__["Title"]
            ),
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](
              _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__[
                "TranslateService"
              ]
            ),
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](
              _app_i18n__WEBPACK_IMPORTED_MODULE_8__["I18nService"]
            )
          );
        };

        AppComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineComponent"
        ]({
          type: AppComponent,
          selectors: [["app-root"]],
          decls: 2,
          vars: 0,
          template: function AppComponent_Template(rf, ctx) {
            if (rf & 1) {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](
                0,
                "router-outlet"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "\n");
            }
          },
          directives: [
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterOutlet"],
          ],
          styles: [
            "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FwcC5jb21wb25lbnQuc2NzcyJ9 */",
          ],
        });
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            AppComponent,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
                args: [
                  {
                    selector: "app-root",
                    templateUrl: "./app.component.html",
                    styleUrls: ["./app.component.scss"],
                  },
                ],
              },
            ],
            function () {
              return [
                {
                  type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"],
                },
                {
                  type:
                    _angular_router__WEBPACK_IMPORTED_MODULE_1__[
                      "ActivatedRoute"
                    ],
                },
                {
                  type:
                    _angular_platform_browser__WEBPACK_IMPORTED_MODULE_2__[
                      "Title"
                    ],
                },
                {
                  type:
                    _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__[
                      "TranslateService"
                    ],
                },
                {
                  type: _app_i18n__WEBPACK_IMPORTED_MODULE_8__["I18nService"],
                },
              ];
            },
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/app.module.ts":
      /*!*******************************!*\
    !*** ./src/app/app.module.ts ***!
    \*******************************/

      /*! exports provided: AppModule */

      /***/
      function srcAppAppModuleTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "AppModule", function () {
          return AppModule;
        });
        /* harmony import */

        var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/platform-browser */
          "./node_modules/@angular/platform-browser/__ivy_ngcc__/fesm2015/platform-browser.js"
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! @angular/forms */
          "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js"
        );
        /* harmony import */

        var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! @angular/common/http */
          "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js"
        );
        /* harmony import */

        var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
          /*! @ngx-translate/core */
          "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js"
        );
        /* harmony import */

        var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
          /*! @ng-bootstrap/ng-bootstrap */
          "./node_modules/@ng-bootstrap/ng-bootstrap/__ivy_ngcc__/fesm2015/ng-bootstrap.js"
        );
        /* harmony import */

        var _core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
          /*! @core */
          "./src/app/@core/index.ts"
        );
        /* harmony import */

        var _shared__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
          /*! @shared */
          "./src/app/@shared/index.ts"
        );
        /* harmony import */

        var _home_home_module__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(
          /*! ./home/home.module */
          "./src/app/home/home.module.ts"
        );
        /* harmony import */

        var _shell_shell_module__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(
          /*! ./shell/shell.module */
          "./src/app/shell/shell.module.ts"
        );
        /* harmony import */

        var _about_about_module__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(
          /*! ./about/about.module */
          "./src/app/about/about.module.ts"
        );
        /* harmony import */

        var _app_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(
          /*! ./app.component */
          "./src/app/app.component.ts"
        );
        /* harmony import */

        var _app_routing_module__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(
          /*! ./app-routing.module */
          "./src/app/app-routing.module.ts"
        );

        var AppModule = function AppModule() {
          _classCallCheck(this, AppModule);
        };

        AppModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_1__[
          "ɵɵdefineNgModule"
        ]({
          type: AppModule,
          bootstrap: [
            _app_component__WEBPACK_IMPORTED_MODULE_11__["AppComponent"],
          ],
        });
        AppModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_1__[
          "ɵɵdefineInjector"
        ]({
          factory: function AppModule_Factory(t) {
            return new (t || AppModule)();
          },
          providers: [],
          imports: [
            [
              _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__[
                "BrowserModule"
              ],
              _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
              _angular_common_http__WEBPACK_IMPORTED_MODULE_3__[
                "HttpClientModule"
              ],
              _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__[
                "TranslateModule"
              ].forRoot(),
              _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_5__[
                "NgbModule"
              ],
              _core__WEBPACK_IMPORTED_MODULE_6__["CoreModule"],
              _shared__WEBPACK_IMPORTED_MODULE_7__["SharedModule"],
              _shell_shell_module__WEBPACK_IMPORTED_MODULE_9__["ShellModule"],
              _home_home_module__WEBPACK_IMPORTED_MODULE_8__["HomeModule"],
              _about_about_module__WEBPACK_IMPORTED_MODULE_10__["AboutModule"],
              _app_routing_module__WEBPACK_IMPORTED_MODULE_12__[
                "AppRoutingModule"
              ],
            ],
          ],
        });

        (function () {
          (typeof ngJitMode === "undefined" || ngJitMode) &&
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵsetNgModuleScope"](
              AppModule,
              {
                declarations: [
                  _app_component__WEBPACK_IMPORTED_MODULE_11__["AppComponent"],
                ],
                imports: [
                  _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__[
                    "BrowserModule"
                  ],
                  _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                  _angular_common_http__WEBPACK_IMPORTED_MODULE_3__[
                    "HttpClientModule"
                  ],
                  _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__[
                    "TranslateModule"
                  ],
                  _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_5__[
                    "NgbModule"
                  ],
                  _core__WEBPACK_IMPORTED_MODULE_6__["CoreModule"],
                  _shared__WEBPACK_IMPORTED_MODULE_7__["SharedModule"],
                  _shell_shell_module__WEBPACK_IMPORTED_MODULE_9__[
                    "ShellModule"
                  ],
                  _home_home_module__WEBPACK_IMPORTED_MODULE_8__["HomeModule"],
                  _about_about_module__WEBPACK_IMPORTED_MODULE_10__[
                    "AboutModule"
                  ],
                  _app_routing_module__WEBPACK_IMPORTED_MODULE_12__[
                    "AppRoutingModule"
                  ],
                ],
              }
            );
        })();
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵsetClassMetadata"](
            AppModule,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"],
                args: [
                  {
                    imports: [
                      _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__[
                        "BrowserModule"
                      ],
                      _angular_forms__WEBPACK_IMPORTED_MODULE_2__[
                        "FormsModule"
                      ],
                      _angular_common_http__WEBPACK_IMPORTED_MODULE_3__[
                        "HttpClientModule"
                      ],
                      _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__[
                        "TranslateModule"
                      ].forRoot(),
                      _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_5__[
                        "NgbModule"
                      ],
                      _core__WEBPACK_IMPORTED_MODULE_6__["CoreModule"],
                      _shared__WEBPACK_IMPORTED_MODULE_7__["SharedModule"],
                      _shell_shell_module__WEBPACK_IMPORTED_MODULE_9__[
                        "ShellModule"
                      ],
                      _home_home_module__WEBPACK_IMPORTED_MODULE_8__[
                        "HomeModule"
                      ],
                      _about_about_module__WEBPACK_IMPORTED_MODULE_10__[
                        "AboutModule"
                      ],
                      _app_routing_module__WEBPACK_IMPORTED_MODULE_12__[
                        "AppRoutingModule"
                      ],
                    ],
                    declarations: [
                      _app_component__WEBPACK_IMPORTED_MODULE_11__[
                        "AppComponent"
                      ],
                    ],
                    providers: [],
                    bootstrap: [
                      _app_component__WEBPACK_IMPORTED_MODULE_11__[
                        "AppComponent"
                      ],
                    ],
                  },
                ],
              },
            ],
            null,
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/home/home-routing.module.ts":
      /*!*********************************************!*\
    !*** ./src/app/home/home-routing.module.ts ***!
    \*********************************************/

      /*! exports provided: HomeRoutingModule */

      /***/
      function srcAppHomeHomeRoutingModuleTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "HomeRoutingModule",
          function () {
            return HomeRoutingModule;
          }
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/router */
          "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js"
        );
        /* harmony import */

        var _home_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! ./home.component */
          "./src/app/home/home.component.ts"
        );
        /* harmony import */

        var _app_shell_shell_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! @app/shell/shell.service */
          "./src/app/shell/shell.service.ts"
        );

        var routes = [
          _app_shell_shell_service__WEBPACK_IMPORTED_MODULE_3__[
            "Shell"
          ].childRoutes([
            {
              path: "",
              redirectTo: "/",
              pathMatch: "full",
            },
            {
              path: "",
              component:
                _home_component__WEBPACK_IMPORTED_MODULE_2__["HomeComponent"],
            },
          ]),
        ];

        var HomeRoutingModule = function HomeRoutingModule() {
          _classCallCheck(this, HomeRoutingModule);
        };

        HomeRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineNgModule"
        ]({
          type: HomeRoutingModule,
        });
        HomeRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineInjector"
        ]({
          factory: function HomeRoutingModule_Factory(t) {
            return new (t || HomeRoutingModule)();
          },
          providers: [],
          imports: [
            [
              _angular_router__WEBPACK_IMPORTED_MODULE_1__[
                "RouterModule"
              ].forChild(routes),
            ],
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"],
          ],
        });

        (function () {
          (typeof ngJitMode === "undefined" || ngJitMode) &&
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](
              HomeRoutingModule,
              {
                imports: [
                  _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"],
                ],
                exports: [
                  _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"],
                ],
              }
            );
        })();
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            HomeRoutingModule,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
                args: [
                  {
                    imports: [
                      _angular_router__WEBPACK_IMPORTED_MODULE_1__[
                        "RouterModule"
                      ].forChild(routes),
                    ],
                    exports: [
                      _angular_router__WEBPACK_IMPORTED_MODULE_1__[
                        "RouterModule"
                      ],
                    ],
                    providers: [],
                  },
                ],
              },
            ],
            null,
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/home/home.component.ts":
      /*!****************************************!*\
    !*** ./src/app/home/home.component.ts ***!
    \****************************************/

      /*! exports provided: HomeComponent */

      /***/
      function srcAppHomeHomeComponentTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "HomeComponent",
          function () {
            return HomeComponent;
          }
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _quote_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! ./quote.service */
          "./src/app/home/quote.service.ts"
        );
        /* harmony import */

        var _shell_shell_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! ../shell/shell.service */
          "./src/app/shell/shell.service.ts"
        );
        /* harmony import */

        var leaflet__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! leaflet */
          "./node_modules/leaflet/dist/leaflet-src.js"
        );
        /* harmony import */

        var leaflet__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/ __webpack_require__.n(
          leaflet__WEBPACK_IMPORTED_MODULE_3__
        );
        /* harmony import */

        var lodash__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
          /*! lodash */
          "./node_modules/lodash/lodash.js"
        );
        /* harmony import */

        var lodash__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/ __webpack_require__.n(
          lodash__WEBPACK_IMPORTED_MODULE_4__
        );
        /* harmony import */

        var leaflet_dist_images_marker_icon_png__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
          /*! leaflet/dist/images/marker-icon.png */
          "./node_modules/leaflet/dist/images/marker-icon.png"
        );
        /* harmony import */

        var leaflet_dist_images_marker_icon_2x_png__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
          /*! leaflet/dist/images/marker-icon-2x.png */
          "./node_modules/leaflet/dist/images/marker-icon-2x.png"
        );
        /* harmony import */

        var leaflet_dist_images_marker_shadow_png__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
          /*! leaflet/dist/images/marker-shadow.png */
          "./node_modules/leaflet/dist/images/marker-shadow.png"
        );
        /* harmony import */

        var _angular_common__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(
          /*! @angular/common */
          "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js"
        );
        /* harmony import */

        var _asymmetrik_ngx_leaflet__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(
          /*! @asymmetrik/ngx-leaflet */
          "./node_modules/@asymmetrik/ngx-leaflet/__ivy_ngcc__/dist/index.js"
        );
        /* harmony import */

        var ng5_slider__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(
          /*! ng5-slider */
          "./node_modules/ng5-slider/__ivy_ngcc__/esm2015/ng5-slider.js"
        );
        /* harmony import */

        var _angular_forms__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(
          /*! @angular/forms */
          "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js"
        );

        var _c0 = function _c0() {
          return {
            standalone: true,
          };
        };

        function HomeComponent_div_1_input_42_Template(rf, ctx) {
          if (rf & 1) {
            var _r10 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵgetCurrentView"
            ]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              0,
              "input",
              24
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"](
              "ngModelChange",
              function HomeComponent_div_1_input_42_Template_input_ngModelChange_0_listener(
                $event
              ) {
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](
                  _r10
                );

                var ctx_r9 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵnextContext"
                ](2);

                return (ctx_r9.opt.floor = $event);
              }
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }

          if (rf & 2) {
            var ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵnextContext"
            ](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
              "ngModel",
              ctx_r1.opt.floor
            )(
              "ngModelOptions",
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](
                2,
                _c0
              )
            );
          }
        }

        function HomeComponent_div_1_span_44_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              0,
              "span"
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "date");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }

          if (rf & 2) {
            var ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵnextContext"
            ](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind2"](
                2,
                1,
                ctx_r2.opt.floor,
                "dd/MM/yyyy HH:mm:ss"
              )
            );
          }
        }

        function HomeComponent_div_1_i_46_Template(rf, ctx) {
          if (rf & 1) {
            var _r12 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵgetCurrentView"
            ]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              0,
              "i",
              25
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"](
              "click",
              function HomeComponent_div_1_i_46_Template_i_click_0_listener() {
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](
                  _r12
                );

                var ctx_r11 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵnextContext"
                ](2);

                return ctx_r11.changeFloorOrCeil("floor");
              }
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        }

        function HomeComponent_div_1_i_48_Template(rf, ctx) {
          if (rf & 1) {
            var _r14 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵgetCurrentView"
            ]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              0,
              "i",
              26
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"](
              "click",
              function HomeComponent_div_1_i_48_Template_i_click_0_listener() {
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](
                  _r14
                );

                var ctx_r13 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵnextContext"
                ](2);

                return ctx_r13.changeFloorOrCeil("floor");
              }
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        }

        function HomeComponent_div_1_input_53_Template(rf, ctx) {
          if (rf & 1) {
            var _r16 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵgetCurrentView"
            ]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              0,
              "input",
              24
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"](
              "ngModelChange",
              function HomeComponent_div_1_input_53_Template_input_ngModelChange_0_listener(
                $event
              ) {
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](
                  _r16
                );

                var ctx_r15 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵnextContext"
                ](2);

                return (ctx_r15.opt.ceil = $event);
              }
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }

          if (rf & 2) {
            var ctx_r5 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵnextContext"
            ](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
              "ngModel",
              ctx_r5.opt.ceil
            )(
              "ngModelOptions",
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](
                2,
                _c0
              )
            );
          }
        }

        function HomeComponent_div_1_span_55_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              0,
              "span"
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "date");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }

          if (rf & 2) {
            var ctx_r6 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵnextContext"
            ](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind2"](
                2,
                1,
                ctx_r6.opt.ceil,
                "dd/MM/yyyy HH:mm:ss"
              )
            );
          }
        }

        function HomeComponent_div_1_i_57_Template(rf, ctx) {
          if (rf & 1) {
            var _r18 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵgetCurrentView"
            ]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              0,
              "i",
              25
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"](
              "click",
              function HomeComponent_div_1_i_57_Template_i_click_0_listener() {
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](
                  _r18
                );

                var ctx_r17 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵnextContext"
                ](2);

                return ctx_r17.changeFloorOrCeil("ceil");
              }
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        }

        function HomeComponent_div_1_i_59_Template(rf, ctx) {
          if (rf & 1) {
            var _r20 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵgetCurrentView"
            ]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              0,
              "i",
              26
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"](
              "click",
              function HomeComponent_div_1_i_59_Template_i_click_0_listener() {
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](
                  _r20
                );

                var ctx_r19 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵnextContext"
                ](2);

                return ctx_r19.changeFloorOrCeil("ceil");
              }
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }
        }

        function HomeComponent_div_1_Template(rf, ctx) {
          if (rf & 1) {
            var _r22 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵgetCurrentView"
            ]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              0,
              "div",
              2
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "\n  ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              2,
              "div",
              3
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, "\n    ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              4,
              "div",
              4
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "\n      ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              6,
              "div",
              5
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              7,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              8,
              "div",
              6
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"](
              "click",
              function HomeComponent_div_1_Template_div_click_8_listener() {
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](
                  _r22
                );

                var ctx_r21 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵnextContext"
                ]();

                return ctx_r21.playSpatioTemporal();
              }
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              9,
              "\n          "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](10, "i", 7);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              11,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              12,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              13,
              "div",
              8
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              14,
              "\n          "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](15, "i", 9);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              16,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              17,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              18,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              19,
              "div",
              10
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              20,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              21,
              "span",
              11
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              22,
              "Period Displayed :"
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              23,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              24,
              "div",
              8
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              25,
              "\n          "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](
              26,
              "i",
              12
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              27,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](28);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](29, "date");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](30, "date");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              31,
              "div",
              13
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              32,
              "\n          "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](
              33,
              "i",
              14
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              34,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              35,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              36,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              37,
              "ng5-slider",
              15
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"](
              "valueChange",
              function HomeComponent_div_1_Template_ng5_slider_valueChange_37_listener(
                $event
              ) {
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](
                  _r22
                );

                var ctx_r23 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵnextContext"
                ]();

                return (ctx_r23.value = $event);
              }
            )(
              "highValueChange",
              function HomeComponent_div_1_Template_ng5_slider_highValueChange_37_listener(
                $event
              ) {
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](
                  _r22
                );

                var ctx_r24 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵnextContext"
                ]();

                return (ctx_r24.maxValue = $event);
              }
            )(
              "optionsChange",
              function HomeComponent_div_1_Template_ng5_slider_optionsChange_37_listener(
                $event
              ) {
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](
                  _r22
                );

                var ctx_r25 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵnextContext"
                ]();

                return (ctx_r25.opt = $event);
              }
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              38,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              39,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              40,
              "div",
              16
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              41,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](
              42,
              HomeComponent_div_1_input_42_Template,
              1,
              3,
              "input",
              17
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              43,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](
              44,
              HomeComponent_div_1_span_44_Template,
              3,
              4,
              "span",
              18
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              45,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](
              46,
              HomeComponent_div_1_i_46_Template,
              1,
              0,
              "i",
              19
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              47,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](
              48,
              HomeComponent_div_1_i_48_Template,
              1,
              0,
              "i",
              20
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              49,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              50,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              51,
              "div",
              21
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              52,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](
              53,
              HomeComponent_div_1_input_53_Template,
              1,
              3,
              "input",
              17
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              54,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](
              55,
              HomeComponent_div_1_span_55_Template,
              3,
              4,
              "span",
              18
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              56,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](
              57,
              HomeComponent_div_1_i_57_Template,
              1,
              0,
              "i",
              19
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              58,
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](
              59,
              HomeComponent_div_1_i_59_Template,
              1,
              0,
              "i",
              20
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              60,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              61,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              62,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              63,
              "div",
              22
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              64,
              "\n        Window (hours) :\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              65,
              "input",
              23
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"](
              "ngModelChange",
              function HomeComponent_div_1_Template_input_ngModelChange_65_listener(
                $event
              ) {
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](
                  _r22
                );

                var ctx_r26 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵnextContext"
                ]();

                return (ctx_r26.windowBetweenFloorAndCeil = $event);
              }
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              66,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              67,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              68,
              "div",
              22
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              69,
              "\n        FPS :\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              70,
              "input",
              23
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"](
              "ngModelChange",
              function HomeComponent_div_1_Template_input_ngModelChange_70_listener(
                $event
              ) {
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](
                  _r22
                );

                var ctx_r27 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵnextContext"
                ]();

                return (ctx_r27.fps = $event);
              }
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
              71,
              "\n      "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](72, "\n    ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](73, "\n  ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](74, "\n");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }

          if (rf & 2) {
            var ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵnextContext"
            ]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](28);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate2"](
              "\n        ",
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind2"](
                29,
                17,
                ctx_r0.value,
                "dd/MM/yyyy HH:mm:ss"
              ),
              " -\n        ",
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind2"](
                30,
                20,
                ctx_r0.maxValue,
                "dd/MM/yyyy HH:mm:ss"
              ),
              "\n        "
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](9);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
              "value",
              ctx_r0.value
            )("highValue", ctx_r0.maxValue)("options", ctx_r0.opt);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
              "ngIf",
              ctx_r0.changeFloor
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
              "ngIf",
              !ctx_r0.changeFloor
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
              "ngIf",
              !ctx_r0.changeFloor
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
              "ngIf",
              ctx_r0.changeFloor
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
              "ngIf",
              ctx_r0.changeCeil
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
              "ngIf",
              !ctx_r0.changeCeil
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
              "ngIf",
              !ctx_r0.changeCeil
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
              "ngIf",
              ctx_r0.changeCeil
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
              "ngModel",
              ctx_r0.windowBetweenFloorAndCeil
            )(
              "ngModelOptions",
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](
                23,
                _c0
              )
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
              "ngModel",
              ctx_r0.fps
            )(
              "ngModelOptions",
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](
                24,
                _c0
              )
            );
          }
        }

        var HomeComponent = /*#__PURE__*/ (function () {
          function HomeComponent(quoteService) {
            _classCallCheck(this, HomeComponent);

            this.quoteService = quoteService;
            this.data = [];
            this.idArray = [];
            this.isSpatial = false;
            this.activeArray = [];
            this.value = 5;
            this.maxValue = 8;
            this.opt = {
              floor: 0,
              ceil: 10,
            };
            this.layers = [];
            this.options = {
              layers: [
                leaflet__WEBPACK_IMPORTED_MODULE_3__["tileLayer"](
                  _shell_shell_service__WEBPACK_IMPORTED_MODULE_2__[
                    "themeFromMapBox"
                  ],
                  {
                    maxZoom: 18,
                    attribution: "...",
                  }
                ),
              ],
              zoom: 4,
              center: leaflet__WEBPACK_IMPORTED_MODULE_3__["latLng"](
                33.88889,
                -118.48143
              ),
            };
          }

          _createClass(HomeComponent, [
            {
              key: "ngOnInit",
              value: function ngOnInit() {
                var _this4 = this;

                this.fps = 0.2;
                this.windowBetweenFloorAndCeil = 3;
                this.changeFloor = false;
                this.changeCeil = false; // Responce for noda server connection

                this.quoteService.getConnectionMessage().then(function (res) {
                  console.log(res);
                }); // Call api to get noda spatio-temporal data

                this.quoteService
                  .getNodaSTData()
                  .then(function (res) {
                    // json parse the responce and import in data variable
                    var parsedData = JSON.parse(res);
                    _this4.data = parsedData["data"]; // JS Date needs milli Epoch Timestamp (so below is a milli epoch converter)

                    console.log(
                      _this4.data,
                      "ayto einai ena date: " +
                        new Date(
                          parseInt(
                            _this4.timestampManipulation(_this4.data[0]["time"])
                          )
                        )
                    );
                    _this4.opt = {
                      floor: parseInt(
                        _this4.timestampManipulation(_this4.data[0]["time"])
                      ),
                      ceil: parseInt(
                        _this4.timestampManipulation(
                          _this4.data[_this4.data.length - 1]["time"]
                        )
                      ),
                    };
                    console.log(
                      "floor",
                      _this4.opt.floor,
                      "ceil",
                      _this4.opt.ceil
                    );
                    _this4.value = _this4.opt.floor;
                    _this4.maxValue =
                      _this4.opt.floor +
                      _this4.windowBetweenFloorAndCeil * 60 * 60 * 1000;
                    _this4.groupedData = lodash__WEBPACK_IMPORTED_MODULE_4__[
                      "groupBy"
                    ](_this4.data, "time");
                    console.log(
                      "auta einai ta grouparismena data",
                      _this4.groupedData
                    ); // for (let key in this.groupedData) {
                    //   this.opt.ticksArray.push(parseInt(this.timestampManipulation(key)));
                    // }
                    // console.log('ticksArray: ', this.opt.ticksArray);

                    var o = Math.round;
                    var r = Math.random;
                    var s = 255;

                    _this4.data.forEach(function (element) {
                      var index = _this4.idArray.findIndex(function (id) {
                        return id.id === element.id;
                      });

                      if (index === -1) {
                        _this4.idArray.push({
                          id: element.id,
                          color:
                            "rgb(" +
                            o(r() * s) +
                            "," +
                            o(r() * s) +
                            "," +
                            o(r() * s) +
                            ")",
                        });
                      }
                    }); // this.createActiveArray()

                    console.log(" auto einai to id array: ", _this4.idArray);
                  })
                  ["catch"](function (err) {
                    console.log(err);
                    _this4.isSpatial = true;
                  }); // Spatial Manipulation

                this.quoteService
                  .getNodaSpatialData()
                  .then(function (res) {
                    var parsedData = JSON.parse(res);
                    _this4.data = parsedData["data"];
                    _this4.groupedData = _this4.data;
                    console.log(
                      "auta einai ta grouparismena data",
                      _this4.groupedData
                    );

                    if (_this4.groupedData[0].id) {
                      var o = Math.round;
                      var r = Math.random;
                      var s = 255;

                      _this4.data.forEach(function (element) {
                        var index = _this4.idArray.findIndex(function (id) {
                          return id.id === element.id;
                        });

                        if (index === -1) {
                          _this4.idArray.push({
                            id: element.id,
                            color:
                              "rgb(" +
                              o(r() * s) +
                              "," +
                              o(r() * s) +
                              "," +
                              o(r() * s) +
                              ")",
                          });
                        }
                      }); // this.createActiveArray()

                      console.log(" auto einai to id array: ", _this4.idArray);
                    }

                    _this4.spatialVisualization();
                  })
                  ["catch"](function (err) {
                    console.log(err);
                    _this4.isSpatial = false;
                  });
              },
            },
            {
              key: "timestampManipulation",
              value: function timestampManipulation(time) {
                var manipulatedTime;

                if (time.length === 13) {
                  manipulatedTime = time;
                } else {
                  manipulatedTime = parseInt((time += "000"));
                }

                return manipulatedTime;
              },
            },
            {
              key: "changeFloorOrCeil",
              value: function changeFloorOrCeil(type) {
                if (type === "floor") {
                  this.changeFloor = !this.changeFloor;
                  console.log(this.opt.floor);
                }

                if (type === "ceil") {
                  this.changeCeil = !this.changeCeil;
                  console.log(this.opt.ceil);
                }
              },
            },
            {
              key: "onMapReady",
              value: function onMapReady(map) {
                this.map = map;
              },
            },
            {
              key: "getRGBofPin",
              value: function getRGBofPin(id) {
                var index = this.idArray.findIndex(function (el) {
                  return el.id === id;
                });
                return this.idArray[index].color;
              },
            },
            {
              key: "spatialVisualization",
              value: function spatialVisualization() {
                var _this5 = this;

                this.groupedData.forEach(function (position) {
                  var lat = position.lat;
                  var lon = position.lon;

                  if (position.id) {
                    var myIcon = leaflet__WEBPACK_IMPORTED_MODULE_3__[
                      "divIcon"
                    ]({
                      html:
                        '<div style="background-color: ' +
                        _this5.getRGBofPin(position.id) +
                        ' ; height: 10px; width: 10px; border-radius: 100%;"></div>',
                    });

                    _this5.layers.push(
                      leaflet__WEBPACK_IMPORTED_MODULE_3__["marker"](
                        [lat, lon],
                        {
                          icon: myIcon,
                        }
                      ) // .bindPopup(
                      //   `<div>CraftID: ` +
                      //     craftID +
                      //     `</div>` +
                      //     `<div>TimeStamp: ` +
                      //     TimeStamp +
                      //     `</div>` +
                      //     `<div>Speed: ` +
                      //     Speed +
                      //     `</div>`
                      // )
                    );
                  } else {
                    var _myIcon = leaflet__WEBPACK_IMPORTED_MODULE_3__[
                      "divIcon"
                    ]({
                      html:
                        '<div style="background-color: green; height: 10px; width: 10px; border-radius: 100%;"></div>',
                    });

                    _this5.layers.push(
                      leaflet__WEBPACK_IMPORTED_MODULE_3__["marker"](
                        [lat, lon],
                        {
                          icon: _myIcon,
                        }
                      ) // .bindPopup(
                      //   `<div>CraftID: ` +
                      //     craftID +
                      //     `</div>` +
                      //     `<div>TimeStamp: ` +
                      //     TimeStamp +
                      //     `</div>` +
                      //     `<div>Speed: ` +
                      //     Speed +
                      //     `</div>`
                      // )
                    );

                    _this5.layers.push(
                      leaflet__WEBPACK_IMPORTED_MODULE_3__["marker"](
                        [lat, lon],
                        {
                          icon: _myIcon,
                        }
                      ) // .bindPopup(
                      //   `<div>CraftID: ` +
                      //     craftID +
                      //     `</div>` +
                      //     `<div>TimeStamp: ` +
                      //     TimeStamp +
                      //     `</div>` +
                      //     `<div>Speed: ` +
                      //     Speed +
                      //     `</div>`
                      // )
                    );
                  }
                });
              },
            },
            {
              key: "playSpatioTemporal",
              value: function playSpatioTemporal() {
                var _this6 = this;

                // this.value = this.opt.floor;
                this.maxValue =
                  this.opt.floor +
                  this.windowBetweenFloorAndCeil * 60 * 60 * 1000;
                var i = 0; // for (let key in this.groupedData) {

                var _loop = function _loop(key) {
                  console.log("eimai akrivos apekso!");
                  i++;
                  setTimeout(function () {
                    if (
                      parseInt(_this6.timestampManipulation(key)) >
                      _this6.opt.floor
                    ) {
                      _this6.groupedData[key].forEach(function (element) {
                        var lat = element.lat;
                        var lon = element.lon;
                        var time = element.time;
                        var myIcon = leaflet__WEBPACK_IMPORTED_MODULE_3__[
                          "divIcon"
                        ]({
                          html:
                            '<div style="background-color: ' +
                            _this6.getRGBofPin(element.id) +
                            ' ; height: 10px; width: 10px; border-radius: 100%;"></div>',
                        }); // this.layers = [];

                        _this6.layers.push(
                          leaflet__WEBPACK_IMPORTED_MODULE_3__["marker"](
                            [lat, lon],
                            {
                              icon: myIcon,
                            }
                          ) // .bindPopup(
                          //   `<div>CraftID: ` +
                          //     craftID +
                          //     `</div>` +
                          //     `<div>TimeStamp: ` +
                          //     TimeStamp +
                          //     `</div>` +
                          //     `<div>Speed: ` +
                          //     Speed +
                          //     `</div>`
                          // )
                        ); // this.value = parseInt(this.timestampManipulation(time));
                        // this.maxValue = this.value + this.windowBetweenFloorAndCeil * 60 * 60 * 1000;
                        // this.map.panTo(new L.LatLng(lat, lon));
                      });
                    }

                    _this6.value = parseInt(_this6.timestampManipulation(key));
                    _this6.maxValue =
                      _this6.value +
                      _this6.windowBetweenFloorAndCeil * 60 * 60 * 1000;

                    if (_this6.layers.length >= 80) {
                      _this6.layers.splice(0, 30);
                    } // console.log("auta einai ta layers", this.layers);
                  }, i * (_this6.fps * 1000));
                };

                for (var key in this.groupedData) {
                  _loop(key);
                }
              },
            },
          ]);

          return HomeComponent;
        })();

        HomeComponent.ɵfac = function HomeComponent_Factory(t) {
          return new (t || HomeComponent)(
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](
              _quote_service__WEBPACK_IMPORTED_MODULE_1__["QuoteService"]
            )
          );
        };

        HomeComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineComponent"
        ]({
          type: HomeComponent,
          selectors: [["app-home"]],
          decls: 6,
          vars: 3,
          consts: [
            ["class", "row w-100 m-0 p-0 webPlayerPositioning", 4, "ngIf"],
            [
              "leaflet",
              "",
              2,
              "height",
              "100vh",
              3,
              "leafletOptions",
              "leafletLayers",
              "leafletMapReady",
            ],
            [1, "row", "w-100", "m-0", "p-0", "webPlayerPositioning"],
            [
              1,
              "col-12",
              "p-0",
              2,
              "box-shadow",
              "0 0 7px 2px rgba(0, 0, 0, 0.283) !important",
            ],
            [
              1,
              "row",
              "w-100",
              "m-0",
              "p-2",
              2,
              "background-color",
              "rgb(85, 85, 85)",
              "border-radius",
              "12px",
            ],
            [1, "col-auto", "align-self-center", 2, "z-index", "1000"],
            [
              1,
              "btn",
              "btn-light",
              "font12",
              "mr-2",
              "p-0",
              "pl-2",
              "pr-2",
              2,
              "padding-top",
              "2px",
              "padding-bottom",
              "2px",
              3,
              "click",
            ],
            [1, "fa", "fa-play"],
            [
              1,
              "btn",
              "btn-light",
              "font12",
              "mr-2",
              "p-0",
              "pl-2",
              "pr-2",
              2,
              "padding-top",
              "2px",
              "padding-bottom",
              "2px",
            ],
            [1, "fa", "fa-pause"],
            [
              1,
              "col-12",
              "p-0",
              "text-center",
              "text-white",
              "font14",
              2,
              "position",
              "absolute",
              "top",
              "10px",
            ],
            [1, "font-weight-bold", "mr-3"],
            [1, "fa", "fa-backward"],
            [
              1,
              "btn",
              "btn-light",
              "font12",
              "ml-2",
              "p-0",
              "pl-2",
              "pr-2",
              2,
              "padding-top",
              "2px",
              "padding-bottom",
              "2px",
            ],
            [1, "fa", "fa-forward"],
            [
              3,
              "value",
              "highValue",
              "options",
              "valueChange",
              "highValueChange",
              "optionsChange",
            ],
            [1, "col-6", "pl-0", "text-white", "font12"],
            [
              "type",
              "datetime-local",
              "class",
              "inputOfDates",
              3,
              "ngModel",
              "ngModelOptions",
              "ngModelChange",
              4,
              "ngIf",
            ],
            [4, "ngIf"],
            [
              "class",
              "fa fa-edit ml-2 pointerToClick",
              "style",
              "color: white !important;",
              3,
              "click",
              4,
              "ngIf",
            ],
            [
              "class",
              "fa fa-check ml-2 pointerToClick",
              "style",
              "color: white !important;",
              3,
              "click",
              4,
              "ngIf",
            ],
            [1, "col-6", "text-right", "pr-0", "text-white", "font12"],
            [1, "col-auto", "text-white", "font12", "mt-3", "pl-0"],
            [
              "type",
              "number",
              1,
              "inputs",
              3,
              "ngModel",
              "ngModelOptions",
              "ngModelChange",
            ],
            [
              "type",
              "datetime-local",
              1,
              "inputOfDates",
              3,
              "ngModel",
              "ngModelOptions",
              "ngModelChange",
            ],
            [
              1,
              "fa",
              "fa-edit",
              "ml-2",
              "pointerToClick",
              2,
              "color",
              "white !important",
              3,
              "click",
            ],
            [
              1,
              "fa",
              "fa-check",
              "ml-2",
              "pointerToClick",
              2,
              "color",
              "white !important",
              3,
              "click",
            ],
          ],
          template: function HomeComponent_Template(rf, ctx) {
            if (rf & 1) {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](0, "\n");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](
                1,
                HomeComponent_div_1_Template,
                75,
                25,
                "div",
                0
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "\n\n");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, "\n");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                4,
                "div",
                1
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"](
                "leafletMapReady",
                function HomeComponent_Template_div_leafletMapReady_4_listener(
                  $event
                ) {
                  return ctx.onMapReady($event);
                }
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "\n");
            }

            if (rf & 2) {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
                "ngIf",
                ctx.isSpatial === false
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
                "leafletOptions",
                ctx.options
              )("leafletLayers", ctx.layers);
            }
          },
          directives: [
            _angular_common__WEBPACK_IMPORTED_MODULE_8__["NgIf"],
            _asymmetrik_ngx_leaflet__WEBPACK_IMPORTED_MODULE_9__[
              "LeafletDirective"
            ],
            _asymmetrik_ngx_leaflet__WEBPACK_IMPORTED_MODULE_9__[
              "LeafletLayersDirective"
            ],
            ng5_slider__WEBPACK_IMPORTED_MODULE_10__["ɵa"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_11__["NumberValueAccessor"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_11__[
              "DefaultValueAccessor"
            ],
            _angular_forms__WEBPACK_IMPORTED_MODULE_11__["NgControlStatus"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_11__["NgModel"],
          ],
          pipes: [_angular_common__WEBPACK_IMPORTED_MODULE_8__["DatePipe"]],
          styles: [
            '@charset "UTF-8";\n.logo[_ngcontent-%COMP%] {\n  width: 100px;\n}\nq[_ngcontent-%COMP%] {\n  font-style: italic;\n  font-size: 1.2rem;\n  quotes: "\xAB " " \xBB";\n}\n.match-parent[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 100%;\n}\n.my-div-icon[_ngcontent-%COMP%] {\n  background-color: red !important;\n  color: 255 !important;\n  height: 2rem;\n  width: 2rem;\n}\n.inputOfDates[_ngcontent-%COMP%] {\n  background-color: rgba(255, 0, 0, 0);\n  color: white;\n  padding-left: 6px;\n  border: 1px solid white;\n  border-radius: 5px;\n  box-shadow: none;\n  outline: none;\n}\n.inputs[_ngcontent-%COMP%] {\n  background-color: rgba(255, 255, 255, 0.171);\n  color: white;\n  padding-left: 6px;\n  border: none;\n  border-radius: 5px;\n  box-shadow: none;\n  outline: none;\n}\n.fa[_ngcontent-%COMP%] {\n  color: #5a5a5a;\n}\ninput[type=date][_ngcontent-%COMP%]::-webkit-inner-spin-button {\n  -webkit-appearance: none;\n  display: none;\n}\ninput[type=date][_ngcontent-%COMP%]::-webkit-calendar-picker-indicator {\n  background-color: rgba(255, 0, 0, 0);\n}\n@media screen and (min-width: 1000px) {\n  .webPlayerPositioning[_ngcontent-%COMP%] {\n    width: 60% !important;\n    overflow-x: hidden;\n    position: absolute;\n    z-index: 1000;\n    bottom: 0.5rem;\n    left: 0.5rem;\n  }\n}\n@media screen and (max-width: 1000px) {\n  .webPlayerPositioning[_ngcontent-%COMP%] {\n    width: 98vw !important;\n    overflow-x: hidden;\n    position: absolute;\n    z-index: 1000;\n    bottom: 0.5rem;\n    left: 0.5rem;\n  }\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvaG9tZS9ob21lLmNvbXBvbmVudC5zY3NzIiwiL1VzZXJzL25pa29za291cy9Ob1NRTC1PcGVyYXRvcnMvbm9kYS12aXN1YWxpemF0aW9uL3NyYy9tYWluL3VpL3NyYy9hcHAvaG9tZS9ob21lLmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLGdCQUFnQjtBQ0FoQjtFQUNFLFlBQUE7QURFRjtBQ0NBO0VBQ0Usa0JBQUE7RUFDQSxpQkFBQTtFQUNBLGlCQUFBO0FERUY7QUNDQTtFQUNFLFdBQUE7RUFDQSxZQUFBO0FERUY7QUNDQTtFQUNFLGdDQUFBO0VBQ0EscUJBQUE7RUFDQSxZQUFBO0VBQ0EsV0FBQTtBREVGO0FDQ0E7RUFDRSxvQ0FBQTtFQUNBLFlBQUE7RUFDQSxpQkFBQTtFQUNBLHVCQUFBO0VBQ0Esa0JBQUE7RUFDQSxnQkFBQTtFQUNBLGFBQUE7QURFRjtBQ0NBO0VBQ0UsNENBQUE7RUFDQSxZQUFBO0VBQ0EsaUJBQUE7RUFDQSxZQUFBO0VBQ0Esa0JBQUE7RUFDQSxnQkFBQTtFQUNBLGFBQUE7QURFRjtBQ0NBO0VBQ0UsY0FBQTtBREVGO0FDQ0E7RUFDRSx3QkFBQTtFQUNBLGFBQUE7QURFRjtBQ0FBO0VBQ0Usb0NBQUE7QURHRjtBQ0FBO0VBQ0U7SUFDRSxxQkFBQTtJQUNBLGtCQUFBO0lBQ0Esa0JBQUE7SUFDQSxhQUFBO0lBQ0EsY0FBQTtJQUNBLFlBQUE7RURHRjtBQUNGO0FDQUE7RUFDRTtJQUNFLHNCQUFBO0lBQ0Esa0JBQUE7SUFDQSxrQkFBQTtJQUNBLGFBQUE7SUFDQSxjQUFBO0lBQ0EsWUFBQTtFREVGO0FBQ0YiLCJmaWxlIjoic3JjL2FwcC9ob21lL2hvbWUuY29tcG9uZW50LnNjc3MiLCJzb3VyY2VzQ29udGVudCI6WyJAY2hhcnNldCBcIlVURi04XCI7XG4ubG9nbyB7XG4gIHdpZHRoOiAxMDBweDtcbn1cblxucSB7XG4gIGZvbnQtc3R5bGU6IGl0YWxpYztcbiAgZm9udC1zaXplOiAxLjJyZW07XG4gIHF1b3RlczogXCLCqyBcIiBcIiDCu1wiO1xufVxuXG4ubWF0Y2gtcGFyZW50IHtcbiAgd2lkdGg6IDEwMCU7XG4gIGhlaWdodDogMTAwJTtcbn1cblxuLm15LWRpdi1pY29uIHtcbiAgYmFja2dyb3VuZC1jb2xvcjogcmVkICFpbXBvcnRhbnQ7XG4gIGNvbG9yOiAyNTUgIWltcG9ydGFudDtcbiAgaGVpZ2h0OiAycmVtO1xuICB3aWR0aDogMnJlbTtcbn1cblxuLmlucHV0T2ZEYXRlcyB7XG4gIGJhY2tncm91bmQtY29sb3I6IHJnYmEoMjU1LCAwLCAwLCAwKTtcbiAgY29sb3I6IHdoaXRlO1xuICBwYWRkaW5nLWxlZnQ6IDZweDtcbiAgYm9yZGVyOiAxcHggc29saWQgd2hpdGU7XG4gIGJvcmRlci1yYWRpdXM6IDVweDtcbiAgYm94LXNoYWRvdzogbm9uZTtcbiAgb3V0bGluZTogbm9uZTtcbn1cblxuLmlucHV0cyB7XG4gIGJhY2tncm91bmQtY29sb3I6IHJnYmEoMjU1LCAyNTUsIDI1NSwgMC4xNzEpO1xuICBjb2xvcjogd2hpdGU7XG4gIHBhZGRpbmctbGVmdDogNnB4O1xuICBib3JkZXI6IG5vbmU7XG4gIGJvcmRlci1yYWRpdXM6IDVweDtcbiAgYm94LXNoYWRvdzogbm9uZTtcbiAgb3V0bGluZTogbm9uZTtcbn1cblxuLmZhIHtcbiAgY29sb3I6ICM1YTVhNWE7XG59XG5cbmlucHV0W3R5cGU9ZGF0ZV06Oi13ZWJraXQtaW5uZXItc3Bpbi1idXR0b24ge1xuICAtd2Via2l0LWFwcGVhcmFuY2U6IG5vbmU7XG4gIGRpc3BsYXk6IG5vbmU7XG59XG5cbmlucHV0W3R5cGU9ZGF0ZV06Oi13ZWJraXQtY2FsZW5kYXItcGlja2VyLWluZGljYXRvciB7XG4gIGJhY2tncm91bmQtY29sb3I6IHJnYmEoMjU1LCAwLCAwLCAwKTtcbn1cblxuQG1lZGlhIHNjcmVlbiBhbmQgKG1pbi13aWR0aDogMTAwMHB4KSB7XG4gIC53ZWJQbGF5ZXJQb3NpdGlvbmluZyB7XG4gICAgd2lkdGg6IDYwJSAhaW1wb3J0YW50O1xuICAgIG92ZXJmbG93LXg6IGhpZGRlbjtcbiAgICBwb3NpdGlvbjogYWJzb2x1dGU7XG4gICAgei1pbmRleDogMTAwMDtcbiAgICBib3R0b206IDAuNXJlbTtcbiAgICBsZWZ0OiAwLjVyZW07XG4gIH1cbn1cbkBtZWRpYSBzY3JlZW4gYW5kIChtYXgtd2lkdGg6IDEwMDBweCkge1xuICAud2ViUGxheWVyUG9zaXRpb25pbmcge1xuICAgIHdpZHRoOiA5OHZ3ICFpbXBvcnRhbnQ7XG4gICAgb3ZlcmZsb3cteDogaGlkZGVuO1xuICAgIHBvc2l0aW9uOiBhYnNvbHV0ZTtcbiAgICB6LWluZGV4OiAxMDAwO1xuICAgIGJvdHRvbTogMC41cmVtO1xuICAgIGxlZnQ6IDAuNXJlbTtcbiAgfVxufSIsIi5sb2dvIHtcbiAgd2lkdGg6IDEwMHB4O1xufVxuXG5xIHtcbiAgZm9udC1zdHlsZTogaXRhbGljO1xuICBmb250LXNpemU6IDEuMnJlbTtcbiAgcXVvdGVzOiBcIsKrIFwiIFwiIMK7XCI7XG59XG5cbi5tYXRjaC1wYXJlbnQge1xuICB3aWR0aDogMTAwJTtcbiAgaGVpZ2h0OiAxMDAlO1xufVxuXG4ubXktZGl2LWljb24ge1xuICBiYWNrZ3JvdW5kLWNvbG9yOiByZWQgIWltcG9ydGFudDtcbiAgY29sb3I6IHJlZCgkY29sb3I6ICNmZjA1MDUpICFpbXBvcnRhbnQ7XG4gIGhlaWdodDogMnJlbTtcbiAgd2lkdGg6IDJyZW07XG59XG5cbi5pbnB1dE9mRGF0ZXMge1xuICBiYWNrZ3JvdW5kLWNvbG9yOiByZ2JhKDI1NSwgMCwgMCwgMCk7XG4gIGNvbG9yOiB3aGl0ZTtcbiAgcGFkZGluZy1sZWZ0OiA2cHg7XG4gIGJvcmRlcjogMXB4IHNvbGlkIHdoaXRlO1xuICBib3JkZXItcmFkaXVzOiA1cHg7XG4gIGJveC1zaGFkb3c6IG5vbmU7XG4gIG91dGxpbmU6IG5vbmU7XG59XG5cbi5pbnB1dHMge1xuICBiYWNrZ3JvdW5kLWNvbG9yOiByZ2JhKDI1NSwgMjU1LCAyNTUsIDAuMTcxKTtcbiAgY29sb3I6IHdoaXRlO1xuICBwYWRkaW5nLWxlZnQ6IDZweDtcbiAgYm9yZGVyOiBub25lO1xuICBib3JkZXItcmFkaXVzOiA1cHg7XG4gIGJveC1zaGFkb3c6IG5vbmU7XG4gIG91dGxpbmU6IG5vbmU7XG59XG5cbi5mYSB7XG4gIGNvbG9yOiByZ2IoOTAsIDkwLCA5MCk7XG59XG5cbmlucHV0W3R5cGU9XCJkYXRlXCJdOjotd2Via2l0LWlubmVyLXNwaW4tYnV0dG9uIHtcbiAgLXdlYmtpdC1hcHBlYXJhbmNlOiBub25lO1xuICBkaXNwbGF5OiBub25lO1xufVxuaW5wdXRbdHlwZT1cImRhdGVcIl06Oi13ZWJraXQtY2FsZW5kYXItcGlja2VyLWluZGljYXRvciB7XG4gIGJhY2tncm91bmQtY29sb3I6IHJnYmEoMjU1LCAwLCAwLCAwKTtcbn1cblxuQG1lZGlhIHNjcmVlbiBhbmQgKG1pbi13aWR0aDogMTAwMHB4KSB7XG4gIC53ZWJQbGF5ZXJQb3NpdGlvbmluZyB7XG4gICAgd2lkdGg6IDYwJSAhaW1wb3J0YW50O1xuICAgIG92ZXJmbG93LXg6IGhpZGRlbjtcbiAgICBwb3NpdGlvbjogYWJzb2x1dGU7XG4gICAgei1pbmRleDogMTAwMDtcbiAgICBib3R0b206IDAuNXJlbTtcbiAgICBsZWZ0OiAwLjVyZW07XG4gIH1cbn1cblxuQG1lZGlhIHNjcmVlbiBhbmQgKG1heC13aWR0aDogMTAwMHB4KSB7XG4gIC53ZWJQbGF5ZXJQb3NpdGlvbmluZyB7XG4gICAgd2lkdGg6IDk4dncgIWltcG9ydGFudDtcbiAgICBvdmVyZmxvdy14OiBoaWRkZW47XG4gICAgcG9zaXRpb246IGFic29sdXRlO1xuICAgIHotaW5kZXg6IDEwMDA7XG4gICAgYm90dG9tOiAwLjVyZW07XG4gICAgbGVmdDogMC41cmVtO1xuICB9XG59XG4iXX0= */',
          ],
        });
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            HomeComponent,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
                args: [
                  {
                    selector: "app-home",
                    templateUrl: "./home.component.html",
                    styleUrls: ["./home.component.scss"],
                  },
                ],
              },
            ],
            function () {
              return [
                {
                  type:
                    _quote_service__WEBPACK_IMPORTED_MODULE_1__["QuoteService"],
                },
              ];
            },
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/home/home.module.ts":
      /*!*************************************!*\
    !*** ./src/app/home/home.module.ts ***!
    \*************************************/

      /*! exports provided: HomeModule */

      /***/
      function srcAppHomeHomeModuleTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "HomeModule", function () {
          return HomeModule;
        });
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/common */
          "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js"
        );
        /* harmony import */

        var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! @ngx-translate/core */
          "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js"
        );
        /* harmony import */

        var _core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! @core */
          "./src/app/@core/index.ts"
        );
        /* harmony import */

        var _shared__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
          /*! @shared */
          "./src/app/@shared/index.ts"
        );
        /* harmony import */

        var _home_routing_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
          /*! ./home-routing.module */
          "./src/app/home/home-routing.module.ts"
        );
        /* harmony import */

        var _home_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
          /*! ./home.component */
          "./src/app/home/home.component.ts"
        );
        /* harmony import */

        var ng5_slider__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
          /*! ng5-slider */
          "./node_modules/ng5-slider/__ivy_ngcc__/esm2015/ng5-slider.js"
        );
        /* harmony import */

        var _asymmetrik_ngx_leaflet__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(
          /*! @asymmetrik/ngx-leaflet */
          "./node_modules/@asymmetrik/ngx-leaflet/__ivy_ngcc__/dist/index.js"
        );
        /* harmony import */

        var _angular_forms__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(
          /*! @angular/forms */
          "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js"
        );

        var HomeModule = function HomeModule() {
          _classCallCheck(this, HomeModule);
        };

        HomeModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineNgModule"
        ]({
          type: HomeModule,
        });
        HomeModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineInjector"
        ]({
          factory: function HomeModule_Factory(t) {
            return new (t || HomeModule)();
          },
          imports: [
            [
              _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
              _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
                "TranslateModule"
              ],
              _asymmetrik_ngx_leaflet__WEBPACK_IMPORTED_MODULE_8__[
                "LeafletModule"
              ],
              _angular_forms__WEBPACK_IMPORTED_MODULE_9__["FormsModule"],
              _angular_forms__WEBPACK_IMPORTED_MODULE_9__[
                "ReactiveFormsModule"
              ],
              ng5_slider__WEBPACK_IMPORTED_MODULE_7__["Ng5SliderModule"],
              _core__WEBPACK_IMPORTED_MODULE_3__["CoreModule"],
              _shared__WEBPACK_IMPORTED_MODULE_4__["SharedModule"],
              _home_routing_module__WEBPACK_IMPORTED_MODULE_5__[
                "HomeRoutingModule"
              ],
            ],
          ],
        });

        (function () {
          (typeof ngJitMode === "undefined" || ngJitMode) &&
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](
              HomeModule,
              {
                declarations: [
                  _home_component__WEBPACK_IMPORTED_MODULE_6__["HomeComponent"],
                ],
                imports: [
                  _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                  _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
                    "TranslateModule"
                  ],
                  _asymmetrik_ngx_leaflet__WEBPACK_IMPORTED_MODULE_8__[
                    "LeafletModule"
                  ],
                  _angular_forms__WEBPACK_IMPORTED_MODULE_9__["FormsModule"],
                  _angular_forms__WEBPACK_IMPORTED_MODULE_9__[
                    "ReactiveFormsModule"
                  ],
                  ng5_slider__WEBPACK_IMPORTED_MODULE_7__["Ng5SliderModule"],
                  _core__WEBPACK_IMPORTED_MODULE_3__["CoreModule"],
                  _shared__WEBPACK_IMPORTED_MODULE_4__["SharedModule"],
                  _home_routing_module__WEBPACK_IMPORTED_MODULE_5__[
                    "HomeRoutingModule"
                  ],
                ],
              }
            );
        })();
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            HomeModule,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
                args: [
                  {
                    imports: [
                      _angular_common__WEBPACK_IMPORTED_MODULE_1__[
                        "CommonModule"
                      ],
                      _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
                        "TranslateModule"
                      ],
                      _asymmetrik_ngx_leaflet__WEBPACK_IMPORTED_MODULE_8__[
                        "LeafletModule"
                      ],
                      _angular_forms__WEBPACK_IMPORTED_MODULE_9__[
                        "FormsModule"
                      ],
                      _angular_forms__WEBPACK_IMPORTED_MODULE_9__[
                        "ReactiveFormsModule"
                      ],
                      ng5_slider__WEBPACK_IMPORTED_MODULE_7__[
                        "Ng5SliderModule"
                      ],
                      _core__WEBPACK_IMPORTED_MODULE_3__["CoreModule"],
                      _shared__WEBPACK_IMPORTED_MODULE_4__["SharedModule"],
                      _home_routing_module__WEBPACK_IMPORTED_MODULE_5__[
                        "HomeRoutingModule"
                      ],
                    ],
                    declarations: [
                      _home_component__WEBPACK_IMPORTED_MODULE_6__[
                        "HomeComponent"
                      ],
                    ],
                  },
                ],
              },
            ],
            null,
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/home/quote.service.ts":
      /*!***************************************!*\
    !*** ./src/app/home/quote.service.ts ***!
    \***************************************/

      /*! exports provided: QuoteService */

      /***/
      function srcAppHomeQuoteServiceTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "QuoteService", function () {
          return QuoteService;
        });
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/common/http */
          "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js"
        );

        var routes = {
          quote: function quote(c) {
            return "/jokes/random?category=".concat(c.category);
          },
        };

        var QuoteService = /*#__PURE__*/ (function () {
          function QuoteService(httpClient) {
            _classCallCheck(this, QuoteService);

            this.httpClient = httpClient;
          }

          _createClass(QuoteService, [
            {
              key: "getConnectionMessage",
              value: function getConnectionMessage() {
                return this.httpClient
                  .get("/connection-message", {
                    responseType: "text",
                  })
                  .toPromise();
              },
            },
            {
              key: "getNodaSTData",
              value: function getNodaSTData() {
                return this.httpClient
                  .get("/noda-st-timelapse", {
                    responseType: "text",
                  })
                  .toPromise();
              },
            },
            {
              key: "getNodaSpatialData",
              value: function getNodaSpatialData() {
                return this.httpClient
                  .get("/noda-spatial", {
                    responseType: "text",
                  })
                  .toPromise();
              },
            },
          ]);

          return QuoteService;
        })();

        QuoteService.ɵfac = function QuoteService_Factory(t) {
          return new (t || QuoteService)(
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](
              _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]
            )
          );
        };

        QuoteService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineInjectable"
        ]({
          token: QuoteService,
          factory: QuoteService.ɵfac,
          providedIn: "root",
        });
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            QuoteService,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
                args: [
                  {
                    providedIn: "root",
                  },
                ],
              },
            ],
            function () {
              return [
                {
                  type:
                    _angular_common_http__WEBPACK_IMPORTED_MODULE_1__[
                      "HttpClient"
                    ],
                },
              ];
            },
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/i18n/i18n.module.ts":
      /*!*************************************!*\
    !*** ./src/app/i18n/i18n.module.ts ***!
    \*************************************/

      /*! exports provided: I18nModule */

      /***/
      function srcAppI18nI18nModuleTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "I18nModule", function () {
          return I18nModule;
        });
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/common */
          "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js"
        );
        /* harmony import */

        var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! @ngx-translate/core */
          "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js"
        );
        /* harmony import */

        var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! @ng-bootstrap/ng-bootstrap */
          "./node_modules/@ng-bootstrap/ng-bootstrap/__ivy_ngcc__/fesm2015/ng-bootstrap.js"
        );
        /* harmony import */

        var _language_selector_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
          /*! ./language-selector.component */
          "./src/app/i18n/language-selector.component.ts"
        );

        var I18nModule = function I18nModule() {
          _classCallCheck(this, I18nModule);
        };

        I18nModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineNgModule"
        ]({
          type: I18nModule,
        });
        I18nModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineInjector"
        ]({
          factory: function I18nModule_Factory(t) {
            return new (t || I18nModule)();
          },
          imports: [
            [
              _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
              _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
                "TranslateModule"
              ],
              _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_3__[
                "NgbModule"
              ],
            ],
          ],
        });

        (function () {
          (typeof ngJitMode === "undefined" || ngJitMode) &&
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](
              I18nModule,
              {
                declarations: [
                  _language_selector_component__WEBPACK_IMPORTED_MODULE_4__[
                    "LanguageSelectorComponent"
                  ],
                ],
                imports: [
                  _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                  _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
                    "TranslateModule"
                  ],
                  _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_3__[
                    "NgbModule"
                  ],
                ],
                exports: [
                  _language_selector_component__WEBPACK_IMPORTED_MODULE_4__[
                    "LanguageSelectorComponent"
                  ],
                ],
              }
            );
        })();
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            I18nModule,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
                args: [
                  {
                    imports: [
                      _angular_common__WEBPACK_IMPORTED_MODULE_1__[
                        "CommonModule"
                      ],
                      _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
                        "TranslateModule"
                      ],
                      _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_3__[
                        "NgbModule"
                      ],
                    ],
                    declarations: [
                      _language_selector_component__WEBPACK_IMPORTED_MODULE_4__[
                        "LanguageSelectorComponent"
                      ],
                    ],
                    exports: [
                      _language_selector_component__WEBPACK_IMPORTED_MODULE_4__[
                        "LanguageSelectorComponent"
                      ],
                    ],
                  },
                ],
              },
            ],
            null,
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/i18n/i18n.service.ts":
      /*!**************************************!*\
    !*** ./src/app/i18n/i18n.service.ts ***!
    \**************************************/

      /*! exports provided: extract, I18nService */

      /***/
      function srcAppI18nI18nServiceTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "extract", function () {
          return extract;
        });
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "I18nService", function () {
          return I18nService;
        });
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @ngx-translate/core */
          "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js"
        );
        /* harmony import */

        var _core_logger_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! @core/logger.service */
          "./src/app/@core/logger.service.ts"
        );
        /* harmony import */

        var _translations_en_US_json__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! ../../translations/en-US.json */
          "./src/translations/en-US.json"
        );

        var _translations_en_US_json__WEBPACK_IMPORTED_MODULE_3___namespace = /*#__PURE__*/ __webpack_require__.t(
          /*! ../../translations/en-US.json */
          "./src/translations/en-US.json",
          1
        );

        var log = new _core_logger_service__WEBPACK_IMPORTED_MODULE_2__[
          "Logger"
        ]("I18nService");
        var languageKey = "language";
        /**
         * Pass-through function to mark a string for translation extraction.
         * Running `npm translations:extract` will include the given string by using this.
         * @param s The string to extract for translation.
         * @return The same string.
         */

        function extract(s) {
          return s;
        }

        var I18nService = /*#__PURE__*/ (function () {
          function I18nService(translateService) {
            _classCallCheck(this, I18nService);

            this.translateService = translateService; // Embed languages to avoid extra HTTP requests

            translateService.setTranslation(
              "en-US",
              _translations_en_US_json__WEBPACK_IMPORTED_MODULE_3__
            );
          }
          /**
           * Initializes i18n for the application.
           * Loads language from local storage if present, or sets default language.
           * @param defaultLanguage The default language to use.
           * @param supportedLanguages The list of supported languages.
           */

          _createClass(I18nService, [
            {
              key: "init",
              value: function init(defaultLanguage, supportedLanguages) {
                this.defaultLanguage = defaultLanguage;
                this.supportedLanguages = supportedLanguages;
                this.language = ""; // Warning: this subscription will always be alive for the app's lifetime

                this.langChangeSubscription = this.translateService.onLangChange.subscribe(
                  function (event) {
                    localStorage.setItem(languageKey, event.lang);
                  }
                );
              },
              /**
               * Cleans up language change subscription.
               */
            },
            {
              key: "destroy",
              value: function destroy() {
                if (this.langChangeSubscription) {
                  this.langChangeSubscription.unsubscribe();
                }
              },
              /**
               * Sets the current language.
               * Note: The current language is saved to the local storage.
               * If no parameter is specified, the language is loaded from local storage (if present).
               * @param language The IETF language code to set.
               */
            },
            {
              key: "language",
              set: function set(language) {
                language =
                  language ||
                  localStorage.getItem(languageKey) ||
                  this.translateService.getBrowserCultureLang();
                var isSupportedLanguage = this.supportedLanguages.includes(
                  language
                ); // If no exact match is found, search without the region

                if (language && !isSupportedLanguage) {
                  language = language.split("-")[0];
                  language =
                    this.supportedLanguages.find(function (supportedLanguage) {
                      return supportedLanguage.startsWith(language);
                    }) || "";
                  isSupportedLanguage = Boolean(language);
                } // Fallback if language is not supported

                if (!isSupportedLanguage) {
                  language = this.defaultLanguage;
                }

                log.debug("Language set to ".concat(language));
                this.translateService.use(language);
              },
              /**
               * Gets the current language.
               * @return The current language code.
               */
              get: function get() {
                return this.translateService.currentLang;
              },
            },
          ]);

          return I18nService;
        })();

        I18nService.ɵfac = function I18nService_Factory(t) {
          return new (t || I18nService)(
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](
              _ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__[
                "TranslateService"
              ]
            )
          );
        };

        I18nService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineInjectable"
        ]({
          token: I18nService,
          factory: I18nService.ɵfac,
          providedIn: "root",
        });
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            I18nService,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
                args: [
                  {
                    providedIn: "root",
                  },
                ],
              },
            ],
            function () {
              return [
                {
                  type:
                    _ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__[
                      "TranslateService"
                    ],
                },
              ];
            },
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/i18n/index.ts":
      /*!*******************************!*\
    !*** ./src/app/i18n/index.ts ***!
    \*******************************/

      /*! exports provided: I18nModule, extract, I18nService, LanguageSelectorComponent */

      /***/
      function srcAppI18nIndexTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony import */

        var _i18n_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! ./i18n.module */
          "./src/app/i18n/i18n.module.ts"
        );
        /* harmony reexport (safe) */

        __webpack_require__.d(__webpack_exports__, "I18nModule", function () {
          return _i18n_module__WEBPACK_IMPORTED_MODULE_0__["I18nModule"];
        });
        /* harmony import */

        var _i18n_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! ./i18n.service */
          "./src/app/i18n/i18n.service.ts"
        );
        /* harmony reexport (safe) */

        __webpack_require__.d(__webpack_exports__, "extract", function () {
          return _i18n_service__WEBPACK_IMPORTED_MODULE_1__["extract"];
        });
        /* harmony reexport (safe) */

        __webpack_require__.d(__webpack_exports__, "I18nService", function () {
          return _i18n_service__WEBPACK_IMPORTED_MODULE_1__["I18nService"];
        });
        /* harmony import */

        var _language_selector_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! ./language-selector.component */
          "./src/app/i18n/language-selector.component.ts"
        );
        /* harmony reexport (safe) */

        __webpack_require__.d(
          __webpack_exports__,
          "LanguageSelectorComponent",
          function () {
            return _language_selector_component__WEBPACK_IMPORTED_MODULE_2__[
              "LanguageSelectorComponent"
            ];
          }
        );
        /***/
      },

    /***/
    "./src/app/i18n/language-selector.component.ts":
      /*!*****************************************************!*\
    !*** ./src/app/i18n/language-selector.component.ts ***!
    \*****************************************************/

      /*! exports provided: LanguageSelectorComponent */

      /***/
      function srcAppI18nLanguageSelectorComponentTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "LanguageSelectorComponent",
          function () {
            return LanguageSelectorComponent;
          }
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _i18n_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! ./i18n.service */
          "./src/app/i18n/i18n.service.ts"
        );
        /* harmony import */

        var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! @ng-bootstrap/ng-bootstrap */
          "./node_modules/@ng-bootstrap/ng-bootstrap/__ivy_ngcc__/fesm2015/ng-bootstrap.js"
        );
        /* harmony import */

        var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! @angular/common */
          "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js"
        );
        /* harmony import */

        var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
          /*! @ngx-translate/core */
          "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js"
        );

        function LanguageSelectorComponent_a_2_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              0,
              "a",
              5
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](
              2,
              "translate"
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }

          if (rf & 2) {
            var ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵnextContext"
            ]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](
              "\n    ",
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](
                2,
                1,
                ctx_r0.currentLanguage
              ),
              "\n  "
            );
          }
        }

        function LanguageSelectorComponent_ng_template_4_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](0, "\n    ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              1,
              "button",
              6
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, "\n  ");
          }

          if (rf & 2) {
            var ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵnextContext"
            ]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](
              "\n      ",
              ctx_r2.currentLanguage,
              "\n    "
            );
          }
        }

        function LanguageSelectorComponent_button_9_Template(rf, ctx) {
          if (rf & 1) {
            var _r6 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
              "ɵɵgetCurrentView"
            ]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
              0,
              "button",
              7
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"](
              "click",
              function LanguageSelectorComponent_button_9_Template_button_click_0_listener() {
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](
                  _r6
                );

                var language_r4 = ctx.$implicit;

                var ctx_r5 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵnextContext"
                ]();

                return ctx_r5.setLanguage(language_r4);
              }
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](
              2,
              "translate"
            );

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }

          if (rf & 2) {
            var language_r4 = ctx.$implicit;

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](
              "\n      ",
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](
                2,
                1,
                language_r4
              ),
              "\n    "
            );
          }
        }

        var _c0 = function _c0(a0) {
          return {
            "nav-item": a0,
          };
        };

        var LanguageSelectorComponent = /*#__PURE__*/ (function () {
          function LanguageSelectorComponent(i18nService) {
            _classCallCheck(this, LanguageSelectorComponent);

            this.i18nService = i18nService;
            this.inNavbar = false;
            this.menuClass = "";
          }

          _createClass(LanguageSelectorComponent, [
            {
              key: "ngOnInit",
              value: function ngOnInit() {},
            },
            {
              key: "setLanguage",
              value: function setLanguage(language) {
                this.i18nService.language = language;
              },
            },
            {
              key: "currentLanguage",
              get: function get() {
                return this.i18nService.language;
              },
            },
            {
              key: "languages",
              get: function get() {
                return this.i18nService.supportedLanguages;
              },
            },
          ]);

          return LanguageSelectorComponent;
        })();

        LanguageSelectorComponent.ɵfac = function LanguageSelectorComponent_Factory(
          t
        ) {
          return new (t || LanguageSelectorComponent)(
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](
              _i18n_service__WEBPACK_IMPORTED_MODULE_1__["I18nService"]
            )
          );
        };

        LanguageSelectorComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineComponent"
        ]({
          type: LanguageSelectorComponent,
          selectors: [["app-language-selector"]],
          inputs: {
            inNavbar: "inNavbar",
            menuClass: "menuClass",
          },
          decls: 13,
          vars: 7,
          consts: [
            ["ngbDropdown", "", 3, "ngClass"],
            [
              "id",
              "language-dropdown",
              "class",
              "nav-link",
              "ngbDropdownToggle",
              "",
              4,
              "ngIf",
              "ngIfElse",
            ],
            ["button", ""],
            [
              "ngbDropdownMenu",
              "",
              "aria-labelledby",
              "language-dropdown",
              3,
              "ngClass",
            ],
            ["class", "dropdown-item", 3, "click", 4, "ngFor", "ngForOf"],
            ["id", "language-dropdown", "ngbDropdownToggle", "", 1, "nav-link"],
            [
              "id",
              "language-dropdown",
              "ngbDropdownToggle",
              "",
              1,
              "btn",
              "btn-sm",
              "btn-secondary",
            ],
            [1, "dropdown-item", 3, "click"],
          ],
          template: function LanguageSelectorComponent_Template(rf, ctx) {
            if (rf & 1) {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                0,
                "div",
                0
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](
                2,
                LanguageSelectorComponent_a_2_Template,
                3,
                3,
                "a",
                1
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](
                4,
                LanguageSelectorComponent_ng_template_4_Template,
                4,
                1,
                "ng-template",
                null,
                2,
                _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                  "ɵɵtemplateRefExtractor"
                ]
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                7,
                "div",
                3
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "\n    ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](
                9,
                LanguageSelectorComponent_button_9_Template,
                3,
                3,
                "button",
                4
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11, "\n");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12, "\n");
            }

            if (rf & 2) {
              var _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
                "ɵɵreference"
              ](5);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
                "ngClass",
                _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](
                  5,
                  _c0,
                  ctx.inNavbar
                )
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
                "ngIf",
                ctx.inNavbar
              )("ngIfElse", _r1);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
                "ngClass",
                ctx.menuClass
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
                "ngForOf",
                ctx.languages
              );
            }
          },
          directives: [
            _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__[
              "NgbDropdown"
            ],
            _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgClass"],
            _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgIf"],
            _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__[
              "NgbDropdownMenu"
            ],
            _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgForOf"],
            _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__[
              "NgbDropdownToggle"
            ],
          ],
          pipes: [
            _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__["TranslatePipe"],
          ],
          styles: [
            ".nav-link.dropdown-toggle[_ngcontent-%COMP%] {\n  cursor: pointer;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9Vc2Vycy9uaWtvc2tvdXMvTm9TUUwtT3BlcmF0b3JzL25vZGEtdmlzdWFsaXphdGlvbi9zcmMvbWFpbi91aS9zcmMvYXBwL2kxOG4vbGFuZ3VhZ2Utc2VsZWN0b3IuY29tcG9uZW50LnNjc3MiLCJzcmMvYXBwL2kxOG4vbGFuZ3VhZ2Utc2VsZWN0b3IuY29tcG9uZW50LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxlQUFBO0FDQ0YiLCJmaWxlIjoic3JjL2FwcC9pMThuL2xhbmd1YWdlLXNlbGVjdG9yLmNvbXBvbmVudC5zY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLm5hdi1saW5rLmRyb3Bkb3duLXRvZ2dsZSB7XG4gIGN1cnNvcjogcG9pbnRlcjtcbn1cbiIsIi5uYXYtbGluay5kcm9wZG93bi10b2dnbGUge1xuICBjdXJzb3I6IHBvaW50ZXI7XG59Il19 */",
          ],
        });
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            LanguageSelectorComponent,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
                args: [
                  {
                    selector: "app-language-selector",
                    templateUrl: "./language-selector.component.html",
                    styleUrls: ["./language-selector.component.scss"],
                  },
                ],
              },
            ],
            function () {
              return [
                {
                  type:
                    _i18n_service__WEBPACK_IMPORTED_MODULE_1__["I18nService"],
                },
              ];
            },
            {
              inNavbar: [
                {
                  type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
                },
              ],
              menuClass: [
                {
                  type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
                },
              ],
            }
          );
        })();
        /***/
      },

    /***/
    "./src/app/shell/header/header.component.ts":
      /*!**************************************************!*\
    !*** ./src/app/shell/header/header.component.ts ***!
    \**************************************************/

      /*! exports provided: HeaderComponent */

      /***/
      function srcAppShellHeaderHeaderComponentTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "HeaderComponent",
          function () {
            return HeaderComponent;
          }
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @ng-bootstrap/ng-bootstrap */
          "./node_modules/@ng-bootstrap/ng-bootstrap/__ivy_ngcc__/fesm2015/ng-bootstrap.js"
        );
        /* harmony import */

        var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! @ngx-translate/core */
          "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js"
        );
        /* harmony import */

        var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! @angular/router */
          "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js"
        );
        /* harmony import */

        var _i18n_language_selector_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
          /*! ../../i18n/language-selector.component */
          "./src/app/i18n/language-selector.component.ts"
        );

        var HeaderComponent = /*#__PURE__*/ (function () {
          function HeaderComponent() {
            _classCallCheck(this, HeaderComponent);

            this.menuHidden = true;
          }

          _createClass(HeaderComponent, [
            {
              key: "ngOnInit",
              value: function ngOnInit() {},
            },
            {
              key: "toggleMenu",
              value: function toggleMenu() {
                this.menuHidden = !this.menuHidden;
              },
            },
          ]);

          return HeaderComponent;
        })();

        HeaderComponent.ɵfac = function HeaderComponent_Factory(t) {
          return new (t || HeaderComponent)();
        };

        HeaderComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineComponent"
        ]({
          type: HeaderComponent,
          selectors: [["app-header"]],
          decls: 41,
          vars: 2,
          consts: [
            [1, "navbar", "navbar-expand-lg", "navbar-dark", "bg-dark"],
            [
              "href",
              "https://github.com/ngx-rocket",
              "translate",
              "",
              1,
              "navbar-brand",
            ],
            [
              "type",
              "button",
              "aria-controls",
              "navbar-menu",
              "aria-label",
              "Toggle navigation",
              1,
              "navbar-toggler",
              3,
              "click",
            ],
            [1, "navbar-toggler-icon"],
            [
              "id",
              "navbar-menu",
              1,
              "collapse",
              "navbar-collapse",
              "float-xs-none",
              3,
              "ngbCollapse",
            ],
            [1, "navbar-nav"],
            [
              "routerLink",
              "/home",
              "routerLinkActive",
              "active",
              1,
              "nav-item",
              "nav-link",
              "text-uppercase",
            ],
            [1, "fas", "fa-home"],
            ["translate", ""],
            [
              "routerLink",
              "/about",
              "routerLinkActive",
              "active",
              1,
              "nav-item",
              "nav-link",
              "text-uppercase",
            ],
            [1, "fas", "fa-question-circle"],
            [1, "navbar-nav", "ml-auto"],
            [
              "inNavbar",
              "true",
              "menuClass",
              "dropdown-menu dropdown-menu-right",
            ],
          ],
          template: function HeaderComponent_Template(rf, ctx) {
            if (rf & 1) {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                0,
                "header"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                2,
                "nav",
                0
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, "\n    ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                4,
                "a",
                1
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                5,
                "APP_NAME"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "\n    ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                7,
                "button",
                2
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"](
                "click",
                function HeaderComponent_Template_button_click_7_listener() {
                  return ctx.toggleMenu();
                }
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                8,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](
                9,
                "span",
                3
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                10,
                "\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                11,
                "\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                12,
                "div",
                4
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                13,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                14,
                "div",
                5
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                15,
                "\n        "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                16,
                "a",
                6
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                17,
                "\n          "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](
                18,
                "i",
                7
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                19,
                "\n          "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                20,
                "span",
                8
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](21, "Home");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                22,
                "\n        "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                23,
                "\n        "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                24,
                "a",
                9
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                25,
                "\n          "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](
                26,
                "i",
                10
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                27,
                "\n          "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                28,
                "span",
                8
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](29, "About");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                30,
                "\n        "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                31,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                32,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                33,
                "div",
                11
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                34,
                "\n        "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](
                35,
                "app-language-selector",
                12
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                36,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                37,
                "\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](38, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](39, "\n");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](40, "\n");
            }

            if (rf & 2) {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵattribute"](
                "aria-expanded",
                !ctx.menuHidden
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
                "ngbCollapse",
                ctx.menuHidden
              );
            }
          },
          directives: [
            _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_1__[
              "NgbNavbar"
            ],
            _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
              "TranslateDirective"
            ],
            _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_1__[
              "NgbCollapse"
            ],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterLinkWithHref"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterLinkActive"],
            _i18n_language_selector_component__WEBPACK_IMPORTED_MODULE_4__[
              "LanguageSelectorComponent"
            ],
          ],
          styles: [
            ".navbar[_ngcontent-%COMP%] {\n  margin-bottom: 1rem;\n}\n.nav-link.dropdown-toggle[_ngcontent-%COMP%] {\n  cursor: pointer;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9Vc2Vycy9uaWtvc2tvdXMvTm9TUUwtT3BlcmF0b3JzL25vZGEtdmlzdWFsaXphdGlvbi9zcmMvbWFpbi91aS9zcmMvdGhlbWUvdGhlbWUtdmFyaWFibGVzLnNjc3MiLCIvVXNlcnMvbmlrb3Nrb3VzL05vU1FMLU9wZXJhdG9ycy9ub2RhLXZpc3VhbGl6YXRpb24vc3JjL21haW4vdWkvc3JjL2FwcC9zaGVsbC9oZWFkZXIvaGVhZGVyLmNvbXBvbmVudC5zY3NzIiwiL1VzZXJzL25pa29za291cy9Ob1NRTC1PcGVyYXRvcnMvbm9kYS12aXN1YWxpemF0aW9uL3NyYy9tYWluL3VpL25vZGVfbW9kdWxlcy9ib290c3RyYXAvc2Nzcy9fdmFyaWFibGVzLnNjc3MiLCJzcmMvYXBwL3NoZWxsL2hlYWRlci9oZWFkZXIuY29tcG9uZW50LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7O0VBQUE7QUNFQTtFQUNFLG1CQ3VJTztBQ3JJVDtBRkNBO0VBQ0UsZUFBQTtBRUVGIiwiZmlsZSI6InNyYy9hcHAvc2hlbGwvaGVhZGVyL2hlYWRlci5jb21wb25lbnQuc2NzcyIsInNvdXJjZXNDb250ZW50IjpbIi8qXG4gKiBBcHBsaWNhdGlvbiBnbG9iYWwgdmFyaWFibGVzLlxuICovXG5cbi8vIFNldCBGb250IEF3ZXNvbWUgZm9udCBwYXRoXG4kZmEtZm9udC1wYXRoOiBcIn5AZm9ydGF3ZXNvbWUvZm9udGF3ZXNvbWUtZnJlZS93ZWJmb250c1wiO1xuXG4vLyAtLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS1cbi8vIEJvb3RzdHJhcCB2YXJpYWJsZXNcbi8vXG4vLyBPdmVycmlkZSBCb290c3RyYXAgdmFyaWFibGVzIGhlcmUgdG8gc3VpdGUgeW91ciB0aGVtZS5cbi8vIENvcHkgdmFyaWFibGVzIHlvdSB3YW50IHRvIGN1c3RvbWl6ZSBmcm9tIG5vZGVfbW9kdWxlcy9ib290c3RyYXAvc2Nzcy9fdmFyaWFibGVzLnNjc3NcblxuLy9cbi8vIENvbG9yIHN5c3RlbVxuLy9cblxuJHdoaXRlOiAjZmZmO1xuJGdyYXktMTAwOiAjZjhmOWZhO1xuJGdyYXktMjAwOiAjZTllY2VmO1xuJGdyYXktMzAwOiAjZGVlMmU2O1xuJGdyYXktNDAwOiAjY2VkNGRhO1xuJGdyYXktNTAwOiAjYWRiNWJkO1xuJGdyYXktNjAwOiAjODY4ZTk2O1xuJGdyYXktNzAwOiAjNDk1MDU3O1xuJGdyYXktODAwOiAjMzQzYTQwO1xuJGdyYXktOTAwOiAjMjEyNTI5O1xuJGJsYWNrOiAjMDAwO1xuXG4kYmx1ZTogIzAwNzNkZDtcbiRpbmRpZ286ICM2NjEwZjI7XG4kcHVycGxlOiAjNmY0MmMxO1xuJHBpbms6ICNlODNlOGM7XG4kcmVkOiAjZGMzNTQ1O1xuJG9yYW5nZTogI2ZkN2UxNDtcbiR5ZWxsb3c6ICNmZmMxMDc7XG4kZ3JlZW46ICMyOGE3NDU7XG4kdGVhbDogIzIwYzk5NztcbiRjeWFuOiAjMTdhMmI4O1xuXG4kdGhlbWUtY29sb3JzOiAoXG4gIHByaW1hcnk6ICRibHVlLFxuICBzZWNvbmRhcnk6ICRncmF5LTYwMCxcbiAgc3VjY2VzczogJGdyZWVuLFxuICBpbmZvOiAkY3lhbixcbiAgd2FybmluZzogJHllbGxvdyxcbiAgZGFuZ2VyOiAkcmVkLFxuICBsaWdodDogJGdyYXktMTAwLFxuICBkYXJrOiAkZ3JheS04MDAsXG4pO1xuXG4vLyBVc2UgQm9vdHN0cmFwIGRlZmF1bHRzIGZvciBvdGhlciB2YXJpYWJsZXMsIGltcG9ydGVkIGhlcmUgc28gd2UgY2FuIGFjY2VzcyBhbGwgYXBwIHZhcmlhYmxlcyBpbiBvbmUgcGxhY2Ugd2hlbiB1c2VkXG4vLyBpbiBjb21wb25lbnRzLlxuQGltcG9ydCBcIn5ib290c3RyYXAvc2Nzcy9fZnVuY3Rpb25zXCI7XG5AaW1wb3J0IFwifmJvb3RzdHJhcC9zY3NzL192YXJpYWJsZXNcIjtcbiIsIkBpbXBvcnQgXCJzcmMvdGhlbWUvdGhlbWUtdmFyaWFibGVzXCI7XG5cbi5uYXZiYXIge1xuICBtYXJnaW4tYm90dG9tOiAkc3BhY2VyO1xufVxuXG4ubmF2LWxpbmsuZHJvcGRvd24tdG9nZ2xlIHtcbiAgY3Vyc29yOiBwb2ludGVyO1xufVxuIiwiLy8gVmFyaWFibGVzXG4vL1xuLy8gVmFyaWFibGVzIHNob3VsZCBmb2xsb3cgdGhlIGAkY29tcG9uZW50LXN0YXRlLXByb3BlcnR5LXNpemVgIGZvcm11bGEgZm9yXG4vLyBjb25zaXN0ZW50IG5hbWluZy4gRXg6ICRuYXYtbGluay1kaXNhYmxlZC1jb2xvciBhbmQgJG1vZGFsLWNvbnRlbnQtYm94LXNoYWRvdy14cy5cblxuLy8gQ29sb3Igc3lzdGVtXG5cbiR3aGl0ZTogICAgI2ZmZiAhZGVmYXVsdDtcbiRncmF5LTEwMDogI2Y4ZjlmYSAhZGVmYXVsdDtcbiRncmF5LTIwMDogI2U5ZWNlZiAhZGVmYXVsdDtcbiRncmF5LTMwMDogI2RlZTJlNiAhZGVmYXVsdDtcbiRncmF5LTQwMDogI2NlZDRkYSAhZGVmYXVsdDtcbiRncmF5LTUwMDogI2FkYjViZCAhZGVmYXVsdDtcbiRncmF5LTYwMDogIzZjNzU3ZCAhZGVmYXVsdDtcbiRncmF5LTcwMDogIzQ5NTA1NyAhZGVmYXVsdDtcbiRncmF5LTgwMDogIzM0M2E0MCAhZGVmYXVsdDtcbiRncmF5LTkwMDogIzIxMjUyOSAhZGVmYXVsdDtcbiRibGFjazogICAgIzAwMCAhZGVmYXVsdDtcblxuJGdyYXlzOiAoKSAhZGVmYXVsdDtcbi8vIHN0eWxlbGludC1kaXNhYmxlLW5leHQtbGluZSBzY3NzL2RvbGxhci12YXJpYWJsZS1kZWZhdWx0XG4kZ3JheXM6IG1hcC1tZXJnZShcbiAgKFxuICAgIFwiMTAwXCI6ICRncmF5LTEwMCxcbiAgICBcIjIwMFwiOiAkZ3JheS0yMDAsXG4gICAgXCIzMDBcIjogJGdyYXktMzAwLFxuICAgIFwiNDAwXCI6ICRncmF5LTQwMCxcbiAgICBcIjUwMFwiOiAkZ3JheS01MDAsXG4gICAgXCI2MDBcIjogJGdyYXktNjAwLFxuICAgIFwiNzAwXCI6ICRncmF5LTcwMCxcbiAgICBcIjgwMFwiOiAkZ3JheS04MDAsXG4gICAgXCI5MDBcIjogJGdyYXktOTAwXG4gICksXG4gICRncmF5c1xuKTtcblxuJGJsdWU6ICAgICMwMDdiZmYgIWRlZmF1bHQ7XG4kaW5kaWdvOiAgIzY2MTBmMiAhZGVmYXVsdDtcbiRwdXJwbGU6ICAjNmY0MmMxICFkZWZhdWx0O1xuJHBpbms6ICAgICNlODNlOGMgIWRlZmF1bHQ7XG4kcmVkOiAgICAgI2RjMzU0NSAhZGVmYXVsdDtcbiRvcmFuZ2U6ICAjZmQ3ZTE0ICFkZWZhdWx0O1xuJHllbGxvdzogICNmZmMxMDcgIWRlZmF1bHQ7XG4kZ3JlZW46ICAgIzI4YTc0NSAhZGVmYXVsdDtcbiR0ZWFsOiAgICAjMjBjOTk3ICFkZWZhdWx0O1xuJGN5YW46ICAgICMxN2EyYjggIWRlZmF1bHQ7XG5cbiRjb2xvcnM6ICgpICFkZWZhdWx0O1xuLy8gc3R5bGVsaW50LWRpc2FibGUtbmV4dC1saW5lIHNjc3MvZG9sbGFyLXZhcmlhYmxlLWRlZmF1bHRcbiRjb2xvcnM6IG1hcC1tZXJnZShcbiAgKFxuICAgIFwiYmx1ZVwiOiAgICAgICAkYmx1ZSxcbiAgICBcImluZGlnb1wiOiAgICAgJGluZGlnbyxcbiAgICBcInB1cnBsZVwiOiAgICAgJHB1cnBsZSxcbiAgICBcInBpbmtcIjogICAgICAgJHBpbmssXG4gICAgXCJyZWRcIjogICAgICAgICRyZWQsXG4gICAgXCJvcmFuZ2VcIjogICAgICRvcmFuZ2UsXG4gICAgXCJ5ZWxsb3dcIjogICAgICR5ZWxsb3csXG4gICAgXCJncmVlblwiOiAgICAgICRncmVlbixcbiAgICBcInRlYWxcIjogICAgICAgJHRlYWwsXG4gICAgXCJjeWFuXCI6ICAgICAgICRjeWFuLFxuICAgIFwid2hpdGVcIjogICAgICAkd2hpdGUsXG4gICAgXCJncmF5XCI6ICAgICAgICRncmF5LTYwMCxcbiAgICBcImdyYXktZGFya1wiOiAgJGdyYXktODAwXG4gICksXG4gICRjb2xvcnNcbik7XG5cbiRwcmltYXJ5OiAgICAgICAkYmx1ZSAhZGVmYXVsdDtcbiRzZWNvbmRhcnk6ICAgICAkZ3JheS02MDAgIWRlZmF1bHQ7XG4kc3VjY2VzczogICAgICAgJGdyZWVuICFkZWZhdWx0O1xuJGluZm86ICAgICAgICAgICRjeWFuICFkZWZhdWx0O1xuJHdhcm5pbmc6ICAgICAgICR5ZWxsb3cgIWRlZmF1bHQ7XG4kZGFuZ2VyOiAgICAgICAgJHJlZCAhZGVmYXVsdDtcbiRsaWdodDogICAgICAgICAkZ3JheS0xMDAgIWRlZmF1bHQ7XG4kZGFyazogICAgICAgICAgJGdyYXktODAwICFkZWZhdWx0O1xuXG4kdGhlbWUtY29sb3JzOiAoKSAhZGVmYXVsdDtcbi8vIHN0eWxlbGludC1kaXNhYmxlLW5leHQtbGluZSBzY3NzL2RvbGxhci12YXJpYWJsZS1kZWZhdWx0XG4kdGhlbWUtY29sb3JzOiBtYXAtbWVyZ2UoXG4gIChcbiAgICBcInByaW1hcnlcIjogICAgJHByaW1hcnksXG4gICAgXCJzZWNvbmRhcnlcIjogICRzZWNvbmRhcnksXG4gICAgXCJzdWNjZXNzXCI6ICAgICRzdWNjZXNzLFxuICAgIFwiaW5mb1wiOiAgICAgICAkaW5mbyxcbiAgICBcIndhcm5pbmdcIjogICAgJHdhcm5pbmcsXG4gICAgXCJkYW5nZXJcIjogICAgICRkYW5nZXIsXG4gICAgXCJsaWdodFwiOiAgICAgICRsaWdodCxcbiAgICBcImRhcmtcIjogICAgICAgJGRhcmtcbiAgKSxcbiAgJHRoZW1lLWNvbG9yc1xuKTtcblxuLy8gU2V0IGEgc3BlY2lmaWMganVtcCBwb2ludCBmb3IgcmVxdWVzdGluZyBjb2xvciBqdW1wc1xuJHRoZW1lLWNvbG9yLWludGVydmFsOiAgICAgIDglICFkZWZhdWx0O1xuXG4vLyBUaGUgeWlxIGxpZ2h0bmVzcyB2YWx1ZSB0aGF0IGRldGVybWluZXMgd2hlbiB0aGUgbGlnaHRuZXNzIG9mIGNvbG9yIGNoYW5nZXMgZnJvbSBcImRhcmtcIiB0byBcImxpZ2h0XCIuIEFjY2VwdGFibGUgdmFsdWVzIGFyZSBiZXR3ZWVuIDAgYW5kIDI1NS5cbiR5aXEtY29udHJhc3RlZC10aHJlc2hvbGQ6ICAxNTAgIWRlZmF1bHQ7XG5cbi8vIEN1c3RvbWl6ZSB0aGUgbGlnaHQgYW5kIGRhcmsgdGV4dCBjb2xvcnMgZm9yIHVzZSBpbiBvdXIgWUlRIGNvbG9yIGNvbnRyYXN0IGZ1bmN0aW9uLlxuJHlpcS10ZXh0LWRhcms6ICAgICAgICAgICAgICRncmF5LTkwMCAhZGVmYXVsdDtcbiR5aXEtdGV4dC1saWdodDogICAgICAgICAgICAkd2hpdGUgIWRlZmF1bHQ7XG5cbi8vIENoYXJhY3RlcnMgd2hpY2ggYXJlIGVzY2FwZWQgYnkgdGhlIGVzY2FwZS1zdmcgZnVuY3Rpb25cbiRlc2NhcGVkLWNoYXJhY3RlcnM6IChcbiAgKFwiPFwiLFwiJTNjXCIpLFxuICAoXCI+XCIsXCIlM2VcIiksXG4gIChcIiNcIixcIiUyM1wiKSxcbiAgKFwiKFwiLFwiJTI4XCIpLFxuICAoXCIpXCIsXCIlMjlcIiksXG4pICFkZWZhdWx0O1xuXG5cbi8vIE9wdGlvbnNcbi8vXG4vLyBRdWlja2x5IG1vZGlmeSBnbG9iYWwgc3R5bGluZyBieSBlbmFibGluZyBvciBkaXNhYmxpbmcgb3B0aW9uYWwgZmVhdHVyZXMuXG5cbiRlbmFibGUtY2FyZXQ6ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICB0cnVlICFkZWZhdWx0O1xuJGVuYWJsZS1yb3VuZGVkOiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIHRydWUgIWRlZmF1bHQ7XG4kZW5hYmxlLXNoYWRvd3M6ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgZmFsc2UgIWRlZmF1bHQ7XG4kZW5hYmxlLWdyYWRpZW50czogICAgICAgICAgICAgICAgICAgICAgICAgICAgZmFsc2UgIWRlZmF1bHQ7XG4kZW5hYmxlLXRyYW5zaXRpb25zOiAgICAgICAgICAgICAgICAgICAgICAgICAgdHJ1ZSAhZGVmYXVsdDtcbiRlbmFibGUtcHJlZmVycy1yZWR1Y2VkLW1vdGlvbi1tZWRpYS1xdWVyeTogICB0cnVlICFkZWZhdWx0O1xuJGVuYWJsZS1ob3Zlci1tZWRpYS1xdWVyeTogICAgICAgICAgICAgICAgICAgIGZhbHNlICFkZWZhdWx0OyAvLyBEZXByZWNhdGVkLCBubyBsb25nZXIgYWZmZWN0cyBhbnkgY29tcGlsZWQgQ1NTXG4kZW5hYmxlLWdyaWQtY2xhc3NlczogICAgICAgICAgICAgICAgICAgICAgICAgdHJ1ZSAhZGVmYXVsdDtcbiRlbmFibGUtcG9pbnRlci1jdXJzb3ItZm9yLWJ1dHRvbnM6ICAgICAgICAgICB0cnVlICFkZWZhdWx0O1xuJGVuYWJsZS1wcmludC1zdHlsZXM6ICAgICAgICAgICAgICAgICAgICAgICAgIHRydWUgIWRlZmF1bHQ7XG4kZW5hYmxlLXJlc3BvbnNpdmUtZm9udC1zaXplczogICAgICAgICAgICAgICAgZmFsc2UgIWRlZmF1bHQ7XG4kZW5hYmxlLXZhbGlkYXRpb24taWNvbnM6ICAgICAgICAgICAgICAgICAgICAgdHJ1ZSAhZGVmYXVsdDtcbiRlbmFibGUtZGVwcmVjYXRpb24tbWVzc2FnZXM6ICAgICAgICAgICAgICAgICB0cnVlICFkZWZhdWx0O1xuXG5cbi8vIFNwYWNpbmdcbi8vXG4vLyBDb250cm9sIHRoZSBkZWZhdWx0IHN0eWxpbmcgb2YgbW9zdCBCb290c3RyYXAgZWxlbWVudHMgYnkgbW9kaWZ5aW5nIHRoZXNlXG4vLyB2YXJpYWJsZXMuIE1vc3RseSBmb2N1c2VkIG9uIHNwYWNpbmcuXG4vLyBZb3UgY2FuIGFkZCBtb3JlIGVudHJpZXMgdG8gdGhlICRzcGFjZXJzIG1hcCwgc2hvdWxkIHlvdSBuZWVkIG1vcmUgdmFyaWF0aW9uLlxuXG4kc3BhY2VyOiAxcmVtICFkZWZhdWx0O1xuJHNwYWNlcnM6ICgpICFkZWZhdWx0O1xuLy8gc3R5bGVsaW50LWRpc2FibGUtbmV4dC1saW5lIHNjc3MvZG9sbGFyLXZhcmlhYmxlLWRlZmF1bHRcbiRzcGFjZXJzOiBtYXAtbWVyZ2UoXG4gIChcbiAgICAwOiAwLFxuICAgIDE6ICgkc3BhY2VyICogLjI1KSxcbiAgICAyOiAoJHNwYWNlciAqIC41KSxcbiAgICAzOiAkc3BhY2VyLFxuICAgIDQ6ICgkc3BhY2VyICogMS41KSxcbiAgICA1OiAoJHNwYWNlciAqIDMpXG4gICksXG4gICRzcGFjZXJzXG4pO1xuXG4vLyBUaGlzIHZhcmlhYmxlIGFmZmVjdHMgdGhlIGAuaC0qYCBhbmQgYC53LSpgIGNsYXNzZXMuXG4kc2l6ZXM6ICgpICFkZWZhdWx0O1xuLy8gc3R5bGVsaW50LWRpc2FibGUtbmV4dC1saW5lIHNjc3MvZG9sbGFyLXZhcmlhYmxlLWRlZmF1bHRcbiRzaXplczogbWFwLW1lcmdlKFxuICAoXG4gICAgMjU6IDI1JSxcbiAgICA1MDogNTAlLFxuICAgIDc1OiA3NSUsXG4gICAgMTAwOiAxMDAlLFxuICAgIGF1dG86IGF1dG9cbiAgKSxcbiAgJHNpemVzXG4pO1xuXG5cbi8vIEJvZHlcbi8vXG4vLyBTZXR0aW5ncyBmb3IgdGhlIGA8Ym9keT5gIGVsZW1lbnQuXG5cbiRib2R5LWJnOiAgICAgICAgICAgICAgICAgICAkd2hpdGUgIWRlZmF1bHQ7XG4kYm9keS1jb2xvcjogICAgICAgICAgICAgICAgJGdyYXktOTAwICFkZWZhdWx0O1xuXG5cbi8vIExpbmtzXG4vL1xuLy8gU3R5bGUgYW5jaG9yIGVsZW1lbnRzLlxuXG4kbGluay1jb2xvcjogICAgICAgICAgICAgICAgICAgICAgICAgICAgICB0aGVtZS1jb2xvcihcInByaW1hcnlcIikgIWRlZmF1bHQ7XG4kbGluay1kZWNvcmF0aW9uOiAgICAgICAgICAgICAgICAgICAgICAgICBub25lICFkZWZhdWx0O1xuJGxpbmstaG92ZXItY29sb3I6ICAgICAgICAgICAgICAgICAgICAgICAgZGFya2VuKCRsaW5rLWNvbG9yLCAxNSUpICFkZWZhdWx0O1xuJGxpbmstaG92ZXItZGVjb3JhdGlvbjogICAgICAgICAgICAgICAgICAgdW5kZXJsaW5lICFkZWZhdWx0O1xuLy8gRGFya2VuIHBlcmNlbnRhZ2UgZm9yIGxpbmtzIHdpdGggYC50ZXh0LSpgIGNsYXNzIChlLmcuIGAudGV4dC1zdWNjZXNzYClcbiRlbXBoYXNpemVkLWxpbmstaG92ZXItZGFya2VuLXBlcmNlbnRhZ2U6IDE1JSAhZGVmYXVsdDtcblxuLy8gUGFyYWdyYXBoc1xuLy9cbi8vIFN0eWxlIHAgZWxlbWVudC5cblxuJHBhcmFncmFwaC1tYXJnaW4tYm90dG9tOiAgIDFyZW0gIWRlZmF1bHQ7XG5cblxuLy8gR3JpZCBicmVha3BvaW50c1xuLy9cbi8vIERlZmluZSB0aGUgbWluaW11bSBkaW1lbnNpb25zIGF0IHdoaWNoIHlvdXIgbGF5b3V0IHdpbGwgY2hhbmdlLFxuLy8gYWRhcHRpbmcgdG8gZGlmZmVyZW50IHNjcmVlbiBzaXplcywgZm9yIHVzZSBpbiBtZWRpYSBxdWVyaWVzLlxuXG4kZ3JpZC1icmVha3BvaW50czogKFxuICB4czogMCxcbiAgc206IDU3NnB4LFxuICBtZDogNzY4cHgsXG4gIGxnOiA5OTJweCxcbiAgeGw6IDEyMDBweFxuKSAhZGVmYXVsdDtcblxuQGluY2x1ZGUgX2Fzc2VydC1hc2NlbmRpbmcoJGdyaWQtYnJlYWtwb2ludHMsIFwiJGdyaWQtYnJlYWtwb2ludHNcIik7XG5AaW5jbHVkZSBfYXNzZXJ0LXN0YXJ0cy1hdC16ZXJvKCRncmlkLWJyZWFrcG9pbnRzLCBcIiRncmlkLWJyZWFrcG9pbnRzXCIpO1xuXG5cbi8vIEdyaWQgY29udGFpbmVyc1xuLy9cbi8vIERlZmluZSB0aGUgbWF4aW11bSB3aWR0aCBvZiBgLmNvbnRhaW5lcmAgZm9yIGRpZmZlcmVudCBzY3JlZW4gc2l6ZXMuXG5cbiRjb250YWluZXItbWF4LXdpZHRoczogKFxuICBzbTogNTQwcHgsXG4gIG1kOiA3MjBweCxcbiAgbGc6IDk2MHB4LFxuICB4bDogMTE0MHB4XG4pICFkZWZhdWx0O1xuXG5AaW5jbHVkZSBfYXNzZXJ0LWFzY2VuZGluZygkY29udGFpbmVyLW1heC13aWR0aHMsIFwiJGNvbnRhaW5lci1tYXgtd2lkdGhzXCIpO1xuXG5cbi8vIEdyaWQgY29sdW1uc1xuLy9cbi8vIFNldCB0aGUgbnVtYmVyIG9mIGNvbHVtbnMgYW5kIHNwZWNpZnkgdGhlIHdpZHRoIG9mIHRoZSBndXR0ZXJzLlxuXG4kZ3JpZC1jb2x1bW5zOiAgICAgICAgICAgICAgICAxMiAhZGVmYXVsdDtcbiRncmlkLWd1dHRlci13aWR0aDogICAgICAgICAgIDMwcHggIWRlZmF1bHQ7XG4kZ3JpZC1yb3ctY29sdW1uczogICAgICAgICAgICA2ICFkZWZhdWx0O1xuXG5cbi8vIENvbXBvbmVudHNcbi8vXG4vLyBEZWZpbmUgY29tbW9uIHBhZGRpbmcgYW5kIGJvcmRlciByYWRpdXMgc2l6ZXMgYW5kIG1vcmUuXG5cbiRsaW5lLWhlaWdodC1sZzogICAgICAgICAgICAgIDEuNSAhZGVmYXVsdDtcbiRsaW5lLWhlaWdodC1zbTogICAgICAgICAgICAgIDEuNSAhZGVmYXVsdDtcblxuJGJvcmRlci13aWR0aDogICAgICAgICAgICAgICAgMXB4ICFkZWZhdWx0O1xuJGJvcmRlci1jb2xvcjogICAgICAgICAgICAgICAgJGdyYXktMzAwICFkZWZhdWx0O1xuXG4kYm9yZGVyLXJhZGl1czogICAgICAgICAgICAgICAuMjVyZW0gIWRlZmF1bHQ7XG4kYm9yZGVyLXJhZGl1cy1sZzogICAgICAgICAgICAuM3JlbSAhZGVmYXVsdDtcbiRib3JkZXItcmFkaXVzLXNtOiAgICAgICAgICAgIC4ycmVtICFkZWZhdWx0O1xuXG4kcm91bmRlZC1waWxsOiAgICAgICAgICAgICAgICA1MHJlbSAhZGVmYXVsdDtcblxuJGJveC1zaGFkb3ctc206ICAgICAgICAgICAgICAgMCAuMTI1cmVtIC4yNXJlbSByZ2JhKCRibGFjaywgLjA3NSkgIWRlZmF1bHQ7XG4kYm94LXNoYWRvdzogICAgICAgICAgICAgICAgICAwIC41cmVtIDFyZW0gcmdiYSgkYmxhY2ssIC4xNSkgIWRlZmF1bHQ7XG4kYm94LXNoYWRvdy1sZzogICAgICAgICAgICAgICAwIDFyZW0gM3JlbSByZ2JhKCRibGFjaywgLjE3NSkgIWRlZmF1bHQ7XG5cbiRjb21wb25lbnQtYWN0aXZlLWNvbG9yOiAgICAgICR3aGl0ZSAhZGVmYXVsdDtcbiRjb21wb25lbnQtYWN0aXZlLWJnOiAgICAgICAgIHRoZW1lLWNvbG9yKFwicHJpbWFyeVwiKSAhZGVmYXVsdDtcblxuJGNhcmV0LXdpZHRoOiAgICAgICAgICAgICAgICAgLjNlbSAhZGVmYXVsdDtcbiRjYXJldC12ZXJ0aWNhbC1hbGlnbjogICAgICAgICRjYXJldC13aWR0aCAqIC44NSAhZGVmYXVsdDtcbiRjYXJldC1zcGFjaW5nOiAgICAgICAgICAgICAgICRjYXJldC13aWR0aCAqIC44NSAhZGVmYXVsdDtcblxuJHRyYW5zaXRpb24tYmFzZTogICAgICAgICAgICAgYWxsIC4ycyBlYXNlLWluLW91dCAhZGVmYXVsdDtcbiR0cmFuc2l0aW9uLWZhZGU6ICAgICAgICAgICAgIG9wYWNpdHkgLjE1cyBsaW5lYXIgIWRlZmF1bHQ7XG4kdHJhbnNpdGlvbi1jb2xsYXBzZTogICAgICAgICBoZWlnaHQgLjM1cyBlYXNlICFkZWZhdWx0O1xuXG4kZW1iZWQtcmVzcG9uc2l2ZS1hc3BlY3QtcmF0aW9zOiAoKSAhZGVmYXVsdDtcbi8vIHN0eWxlbGludC1kaXNhYmxlLW5leHQtbGluZSBzY3NzL2RvbGxhci12YXJpYWJsZS1kZWZhdWx0XG4kZW1iZWQtcmVzcG9uc2l2ZS1hc3BlY3QtcmF0aW9zOiBqb2luKFxuICAoXG4gICAgKDIxIDkpLFxuICAgICgxNiA5KSxcbiAgICAoNCAzKSxcbiAgICAoMSAxKSxcbiAgKSxcbiAgJGVtYmVkLXJlc3BvbnNpdmUtYXNwZWN0LXJhdGlvc1xuKTtcblxuLy8gVHlwb2dyYXBoeVxuLy9cbi8vIEZvbnQsIGxpbmUtaGVpZ2h0LCBhbmQgY29sb3IgZm9yIGJvZHkgdGV4dCwgaGVhZGluZ3MsIGFuZCBtb3JlLlxuXG4vLyBzdHlsZWxpbnQtZGlzYWJsZSB2YWx1ZS1rZXl3b3JkLWNhc2VcbiRmb250LWZhbWlseS1zYW5zLXNlcmlmOiAgICAgIC1hcHBsZS1zeXN0ZW0sIEJsaW5rTWFjU3lzdGVtRm9udCwgXCJTZWdvZSBVSVwiLCBSb2JvdG8sIFwiSGVsdmV0aWNhIE5ldWVcIiwgQXJpYWwsIFwiTm90byBTYW5zXCIsIHNhbnMtc2VyaWYsIFwiQXBwbGUgQ29sb3IgRW1vamlcIiwgXCJTZWdvZSBVSSBFbW9qaVwiLCBcIlNlZ29lIFVJIFN5bWJvbFwiLCBcIk5vdG8gQ29sb3IgRW1vamlcIiAhZGVmYXVsdDtcbiRmb250LWZhbWlseS1tb25vc3BhY2U6ICAgICAgIFNGTW9uby1SZWd1bGFyLCBNZW5sbywgTW9uYWNvLCBDb25zb2xhcywgXCJMaWJlcmF0aW9uIE1vbm9cIiwgXCJDb3VyaWVyIE5ld1wiLCBtb25vc3BhY2UgIWRlZmF1bHQ7XG4kZm9udC1mYW1pbHktYmFzZTogICAgICAgICAgICAkZm9udC1mYW1pbHktc2Fucy1zZXJpZiAhZGVmYXVsdDtcbi8vIHN0eWxlbGludC1lbmFibGUgdmFsdWUta2V5d29yZC1jYXNlXG5cbiRmb250LXNpemUtYmFzZTogICAgICAgICAgICAgIDFyZW0gIWRlZmF1bHQ7IC8vIEFzc3VtZXMgdGhlIGJyb3dzZXIgZGVmYXVsdCwgdHlwaWNhbGx5IGAxNnB4YFxuJGZvbnQtc2l6ZS1sZzogICAgICAgICAgICAgICAgJGZvbnQtc2l6ZS1iYXNlICogMS4yNSAhZGVmYXVsdDtcbiRmb250LXNpemUtc206ICAgICAgICAgICAgICAgICRmb250LXNpemUtYmFzZSAqIC44NzUgIWRlZmF1bHQ7XG5cbiRmb250LXdlaWdodC1saWdodGVyOiAgICAgICAgIGxpZ2h0ZXIgIWRlZmF1bHQ7XG4kZm9udC13ZWlnaHQtbGlnaHQ6ICAgICAgICAgICAzMDAgIWRlZmF1bHQ7XG4kZm9udC13ZWlnaHQtbm9ybWFsOiAgICAgICAgICA0MDAgIWRlZmF1bHQ7XG4kZm9udC13ZWlnaHQtYm9sZDogICAgICAgICAgICA3MDAgIWRlZmF1bHQ7XG4kZm9udC13ZWlnaHQtYm9sZGVyOiAgICAgICAgICBib2xkZXIgIWRlZmF1bHQ7XG5cbiRmb250LXdlaWdodC1iYXNlOiAgICAgICAgICAgICRmb250LXdlaWdodC1ub3JtYWwgIWRlZmF1bHQ7XG4kbGluZS1oZWlnaHQtYmFzZTogICAgICAgICAgICAxLjUgIWRlZmF1bHQ7XG5cbiRoMS1mb250LXNpemU6ICAgICAgICAgICAgICAgICRmb250LXNpemUtYmFzZSAqIDIuNSAhZGVmYXVsdDtcbiRoMi1mb250LXNpemU6ICAgICAgICAgICAgICAgICRmb250LXNpemUtYmFzZSAqIDIgIWRlZmF1bHQ7XG4kaDMtZm9udC1zaXplOiAgICAgICAgICAgICAgICAkZm9udC1zaXplLWJhc2UgKiAxLjc1ICFkZWZhdWx0O1xuJGg0LWZvbnQtc2l6ZTogICAgICAgICAgICAgICAgJGZvbnQtc2l6ZS1iYXNlICogMS41ICFkZWZhdWx0O1xuJGg1LWZvbnQtc2l6ZTogICAgICAgICAgICAgICAgJGZvbnQtc2l6ZS1iYXNlICogMS4yNSAhZGVmYXVsdDtcbiRoNi1mb250LXNpemU6ICAgICAgICAgICAgICAgICRmb250LXNpemUtYmFzZSAhZGVmYXVsdDtcblxuJGhlYWRpbmdzLW1hcmdpbi1ib3R0b206ICAgICAgJHNwYWNlciAvIDIgIWRlZmF1bHQ7XG4kaGVhZGluZ3MtZm9udC1mYW1pbHk6ICAgICAgICBudWxsICFkZWZhdWx0O1xuJGhlYWRpbmdzLWZvbnQtd2VpZ2h0OiAgICAgICAgNTAwICFkZWZhdWx0O1xuJGhlYWRpbmdzLWxpbmUtaGVpZ2h0OiAgICAgICAgMS4yICFkZWZhdWx0O1xuJGhlYWRpbmdzLWNvbG9yOiAgICAgICAgICAgICAgbnVsbCAhZGVmYXVsdDtcblxuJGRpc3BsYXkxLXNpemU6ICAgICAgICAgICAgICAgNnJlbSAhZGVmYXVsdDtcbiRkaXNwbGF5Mi1zaXplOiAgICAgICAgICAgICAgIDUuNXJlbSAhZGVmYXVsdDtcbiRkaXNwbGF5My1zaXplOiAgICAgICAgICAgICAgIDQuNXJlbSAhZGVmYXVsdDtcbiRkaXNwbGF5NC1zaXplOiAgICAgICAgICAgICAgIDMuNXJlbSAhZGVmYXVsdDtcblxuJGRpc3BsYXkxLXdlaWdodDogICAgICAgICAgICAgMzAwICFkZWZhdWx0O1xuJGRpc3BsYXkyLXdlaWdodDogICAgICAgICAgICAgMzAwICFkZWZhdWx0O1xuJGRpc3BsYXkzLXdlaWdodDogICAgICAgICAgICAgMzAwICFkZWZhdWx0O1xuJGRpc3BsYXk0LXdlaWdodDogICAgICAgICAgICAgMzAwICFkZWZhdWx0O1xuJGRpc3BsYXktbGluZS1oZWlnaHQ6ICAgICAgICAgJGhlYWRpbmdzLWxpbmUtaGVpZ2h0ICFkZWZhdWx0O1xuXG4kbGVhZC1mb250LXNpemU6ICAgICAgICAgICAgICAkZm9udC1zaXplLWJhc2UgKiAxLjI1ICFkZWZhdWx0O1xuJGxlYWQtZm9udC13ZWlnaHQ6ICAgICAgICAgICAgMzAwICFkZWZhdWx0O1xuXG4kc21hbGwtZm9udC1zaXplOiAgICAgICAgICAgICA4MCUgIWRlZmF1bHQ7XG5cbiR0ZXh0LW11dGVkOiAgICAgICAgICAgICAgICAgICRncmF5LTYwMCAhZGVmYXVsdDtcblxuJGJsb2NrcXVvdGUtc21hbGwtY29sb3I6ICAgICAgJGdyYXktNjAwICFkZWZhdWx0O1xuJGJsb2NrcXVvdGUtc21hbGwtZm9udC1zaXplOiAgJHNtYWxsLWZvbnQtc2l6ZSAhZGVmYXVsdDtcbiRibG9ja3F1b3RlLWZvbnQtc2l6ZTogICAgICAgICRmb250LXNpemUtYmFzZSAqIDEuMjUgIWRlZmF1bHQ7XG5cbiRoci1ib3JkZXItY29sb3I6ICAgICAgICAgICAgIHJnYmEoJGJsYWNrLCAuMSkgIWRlZmF1bHQ7XG4kaHItYm9yZGVyLXdpZHRoOiAgICAgICAgICAgICAkYm9yZGVyLXdpZHRoICFkZWZhdWx0O1xuXG4kbWFyay1wYWRkaW5nOiAgICAgICAgICAgICAgICAuMmVtICFkZWZhdWx0O1xuXG4kZHQtZm9udC13ZWlnaHQ6ICAgICAgICAgICAgICAkZm9udC13ZWlnaHQtYm9sZCAhZGVmYXVsdDtcblxuJGtiZC1ib3gtc2hhZG93OiAgICAgICAgICAgICAgaW5zZXQgMCAtLjFyZW0gMCByZ2JhKCRibGFjaywgLjI1KSAhZGVmYXVsdDtcbiRuZXN0ZWQta2JkLWZvbnQtd2VpZ2h0OiAgICAgICRmb250LXdlaWdodC1ib2xkICFkZWZhdWx0O1xuXG4kbGlzdC1pbmxpbmUtcGFkZGluZzogICAgICAgICAuNXJlbSAhZGVmYXVsdDtcblxuJG1hcmstYmc6ICAgICAgICAgICAgICAgICAgICAgI2ZjZjhlMyAhZGVmYXVsdDtcblxuJGhyLW1hcmdpbi15OiAgICAgICAgICAgICAgICAgJHNwYWNlciAhZGVmYXVsdDtcblxuXG4vLyBUYWJsZXNcbi8vXG4vLyBDdXN0b21pemVzIHRoZSBgLnRhYmxlYCBjb21wb25lbnQgd2l0aCBiYXNpYyB2YWx1ZXMsIGVhY2ggdXNlZCBhY3Jvc3MgYWxsIHRhYmxlIHZhcmlhdGlvbnMuXG5cbiR0YWJsZS1jZWxsLXBhZGRpbmc6ICAgICAgICAgIC43NXJlbSAhZGVmYXVsdDtcbiR0YWJsZS1jZWxsLXBhZGRpbmctc206ICAgICAgIC4zcmVtICFkZWZhdWx0O1xuXG4kdGFibGUtY29sb3I6ICAgICAgICAgICAgICAgICAkYm9keS1jb2xvciAhZGVmYXVsdDtcbiR0YWJsZS1iZzogICAgICAgICAgICAgICAgICAgIG51bGwgIWRlZmF1bHQ7XG4kdGFibGUtYWNjZW50LWJnOiAgICAgICAgICAgICByZ2JhKCRibGFjaywgLjA1KSAhZGVmYXVsdDtcbiR0YWJsZS1ob3Zlci1jb2xvcjogICAgICAgICAgICR0YWJsZS1jb2xvciAhZGVmYXVsdDtcbiR0YWJsZS1ob3Zlci1iZzogICAgICAgICAgICAgIHJnYmEoJGJsYWNrLCAuMDc1KSAhZGVmYXVsdDtcbiR0YWJsZS1hY3RpdmUtYmc6ICAgICAgICAgICAgICR0YWJsZS1ob3Zlci1iZyAhZGVmYXVsdDtcblxuJHRhYmxlLWJvcmRlci13aWR0aDogICAgICAgICAgJGJvcmRlci13aWR0aCAhZGVmYXVsdDtcbiR0YWJsZS1ib3JkZXItY29sb3I6ICAgICAgICAgICRib3JkZXItY29sb3IgIWRlZmF1bHQ7XG5cbiR0YWJsZS1oZWFkLWJnOiAgICAgICAgICAgICAgICRncmF5LTIwMCAhZGVmYXVsdDtcbiR0YWJsZS1oZWFkLWNvbG9yOiAgICAgICAgICAgICRncmF5LTcwMCAhZGVmYXVsdDtcblxuJHRhYmxlLWRhcmstY29sb3I6ICAgICAgICAgICAgJHdoaXRlICFkZWZhdWx0O1xuJHRhYmxlLWRhcmstYmc6ICAgICAgICAgICAgICAgJGdyYXktODAwICFkZWZhdWx0O1xuJHRhYmxlLWRhcmstYWNjZW50LWJnOiAgICAgICAgcmdiYSgkd2hpdGUsIC4wNSkgIWRlZmF1bHQ7XG4kdGFibGUtZGFyay1ob3Zlci1jb2xvcjogICAgICAkdGFibGUtZGFyay1jb2xvciAhZGVmYXVsdDtcbiR0YWJsZS1kYXJrLWhvdmVyLWJnOiAgICAgICAgIHJnYmEoJHdoaXRlLCAuMDc1KSAhZGVmYXVsdDtcbiR0YWJsZS1kYXJrLWJvcmRlci1jb2xvcjogICAgIGxpZ2h0ZW4oJHRhYmxlLWRhcmstYmcsIDcuNSUpICFkZWZhdWx0O1xuXG4kdGFibGUtc3RyaXBlZC1vcmRlcjogICAgICAgICBvZGQgIWRlZmF1bHQ7XG5cbiR0YWJsZS1jYXB0aW9uLWNvbG9yOiAgICAgICAgICR0ZXh0LW11dGVkICFkZWZhdWx0O1xuXG4kdGFibGUtYmctbGV2ZWw6ICAgICAgICAgICAgICAtOSAhZGVmYXVsdDtcbiR0YWJsZS1ib3JkZXItbGV2ZWw6ICAgICAgICAgIC02ICFkZWZhdWx0O1xuXG5cbi8vIEJ1dHRvbnMgKyBGb3Jtc1xuLy9cbi8vIFNoYXJlZCB2YXJpYWJsZXMgdGhhdCBhcmUgcmVhc3NpZ25lZCB0byBgJGlucHV0LWAgYW5kIGAkYnRuLWAgc3BlY2lmaWMgdmFyaWFibGVzLlxuXG4kaW5wdXQtYnRuLXBhZGRpbmcteTogICAgICAgICAuMzc1cmVtICFkZWZhdWx0O1xuJGlucHV0LWJ0bi1wYWRkaW5nLXg6ICAgICAgICAgLjc1cmVtICFkZWZhdWx0O1xuJGlucHV0LWJ0bi1mb250LWZhbWlseTogICAgICAgbnVsbCAhZGVmYXVsdDtcbiRpbnB1dC1idG4tZm9udC1zaXplOiAgICAgICAgICRmb250LXNpemUtYmFzZSAhZGVmYXVsdDtcbiRpbnB1dC1idG4tbGluZS1oZWlnaHQ6ICAgICAgICRsaW5lLWhlaWdodC1iYXNlICFkZWZhdWx0O1xuXG4kaW5wdXQtYnRuLWZvY3VzLXdpZHRoOiAgICAgICAuMnJlbSAhZGVmYXVsdDtcbiRpbnB1dC1idG4tZm9jdXMtY29sb3I6ICAgICAgIHJnYmEoJGNvbXBvbmVudC1hY3RpdmUtYmcsIC4yNSkgIWRlZmF1bHQ7XG4kaW5wdXQtYnRuLWZvY3VzLWJveC1zaGFkb3c6ICAwIDAgMCAkaW5wdXQtYnRuLWZvY3VzLXdpZHRoICRpbnB1dC1idG4tZm9jdXMtY29sb3IgIWRlZmF1bHQ7XG5cbiRpbnB1dC1idG4tcGFkZGluZy15LXNtOiAgICAgIC4yNXJlbSAhZGVmYXVsdDtcbiRpbnB1dC1idG4tcGFkZGluZy14LXNtOiAgICAgIC41cmVtICFkZWZhdWx0O1xuJGlucHV0LWJ0bi1mb250LXNpemUtc206ICAgICAgJGZvbnQtc2l6ZS1zbSAhZGVmYXVsdDtcbiRpbnB1dC1idG4tbGluZS1oZWlnaHQtc206ICAgICRsaW5lLWhlaWdodC1zbSAhZGVmYXVsdDtcblxuJGlucHV0LWJ0bi1wYWRkaW5nLXktbGc6ICAgICAgLjVyZW0gIWRlZmF1bHQ7XG4kaW5wdXQtYnRuLXBhZGRpbmcteC1sZzogICAgICAxcmVtICFkZWZhdWx0O1xuJGlucHV0LWJ0bi1mb250LXNpemUtbGc6ICAgICAgJGZvbnQtc2l6ZS1sZyAhZGVmYXVsdDtcbiRpbnB1dC1idG4tbGluZS1oZWlnaHQtbGc6ICAgICRsaW5lLWhlaWdodC1sZyAhZGVmYXVsdDtcblxuJGlucHV0LWJ0bi1ib3JkZXItd2lkdGg6ICAgICAgJGJvcmRlci13aWR0aCAhZGVmYXVsdDtcblxuXG4vLyBCdXR0b25zXG4vL1xuLy8gRm9yIGVhY2ggb2YgQm9vdHN0cmFwJ3MgYnV0dG9ucywgZGVmaW5lIHRleHQsIGJhY2tncm91bmQsIGFuZCBib3JkZXIgY29sb3IuXG5cbiRidG4tcGFkZGluZy15OiAgICAgICAgICAgICAgICRpbnB1dC1idG4tcGFkZGluZy15ICFkZWZhdWx0O1xuJGJ0bi1wYWRkaW5nLXg6ICAgICAgICAgICAgICAgJGlucHV0LWJ0bi1wYWRkaW5nLXggIWRlZmF1bHQ7XG4kYnRuLWZvbnQtZmFtaWx5OiAgICAgICAgICAgICAkaW5wdXQtYnRuLWZvbnQtZmFtaWx5ICFkZWZhdWx0O1xuJGJ0bi1mb250LXNpemU6ICAgICAgICAgICAgICAgJGlucHV0LWJ0bi1mb250LXNpemUgIWRlZmF1bHQ7XG4kYnRuLWxpbmUtaGVpZ2h0OiAgICAgICAgICAgICAkaW5wdXQtYnRuLWxpbmUtaGVpZ2h0ICFkZWZhdWx0O1xuJGJ0bi13aGl0ZS1zcGFjZTogICAgICAgICAgICAgbnVsbCAhZGVmYXVsdDsgLy8gU2V0IHRvIGBub3dyYXBgIHRvIHByZXZlbnQgdGV4dCB3cmFwcGluZ1xuXG4kYnRuLXBhZGRpbmcteS1zbTogICAgICAgICAgICAkaW5wdXQtYnRuLXBhZGRpbmcteS1zbSAhZGVmYXVsdDtcbiRidG4tcGFkZGluZy14LXNtOiAgICAgICAgICAgICRpbnB1dC1idG4tcGFkZGluZy14LXNtICFkZWZhdWx0O1xuJGJ0bi1mb250LXNpemUtc206ICAgICAgICAgICAgJGlucHV0LWJ0bi1mb250LXNpemUtc20gIWRlZmF1bHQ7XG4kYnRuLWxpbmUtaGVpZ2h0LXNtOiAgICAgICAgICAkaW5wdXQtYnRuLWxpbmUtaGVpZ2h0LXNtICFkZWZhdWx0O1xuXG4kYnRuLXBhZGRpbmcteS1sZzogICAgICAgICAgICAkaW5wdXQtYnRuLXBhZGRpbmcteS1sZyAhZGVmYXVsdDtcbiRidG4tcGFkZGluZy14LWxnOiAgICAgICAgICAgICRpbnB1dC1idG4tcGFkZGluZy14LWxnICFkZWZhdWx0O1xuJGJ0bi1mb250LXNpemUtbGc6ICAgICAgICAgICAgJGlucHV0LWJ0bi1mb250LXNpemUtbGcgIWRlZmF1bHQ7XG4kYnRuLWxpbmUtaGVpZ2h0LWxnOiAgICAgICAgICAkaW5wdXQtYnRuLWxpbmUtaGVpZ2h0LWxnICFkZWZhdWx0O1xuXG4kYnRuLWJvcmRlci13aWR0aDogICAgICAgICAgICAkaW5wdXQtYnRuLWJvcmRlci13aWR0aCAhZGVmYXVsdDtcblxuJGJ0bi1mb250LXdlaWdodDogICAgICAgICAgICAgJGZvbnQtd2VpZ2h0LW5vcm1hbCAhZGVmYXVsdDtcbiRidG4tYm94LXNoYWRvdzogICAgICAgICAgICAgIGluc2V0IDAgMXB4IDAgcmdiYSgkd2hpdGUsIC4xNSksIDAgMXB4IDFweCByZ2JhKCRibGFjaywgLjA3NSkgIWRlZmF1bHQ7XG4kYnRuLWZvY3VzLXdpZHRoOiAgICAgICAgICAgICAkaW5wdXQtYnRuLWZvY3VzLXdpZHRoICFkZWZhdWx0O1xuJGJ0bi1mb2N1cy1ib3gtc2hhZG93OiAgICAgICAgJGlucHV0LWJ0bi1mb2N1cy1ib3gtc2hhZG93ICFkZWZhdWx0O1xuJGJ0bi1kaXNhYmxlZC1vcGFjaXR5OiAgICAgICAgLjY1ICFkZWZhdWx0O1xuJGJ0bi1hY3RpdmUtYm94LXNoYWRvdzogICAgICAgaW5zZXQgMCAzcHggNXB4IHJnYmEoJGJsYWNrLCAuMTI1KSAhZGVmYXVsdDtcblxuJGJ0bi1saW5rLWRpc2FibGVkLWNvbG9yOiAgICAgJGdyYXktNjAwICFkZWZhdWx0O1xuXG4kYnRuLWJsb2NrLXNwYWNpbmcteTogICAgICAgICAuNXJlbSAhZGVmYXVsdDtcblxuLy8gQWxsb3dzIGZvciBjdXN0b21pemluZyBidXR0b24gcmFkaXVzIGluZGVwZW5kZW50bHkgZnJvbSBnbG9iYWwgYm9yZGVyIHJhZGl1c1xuJGJ0bi1ib3JkZXItcmFkaXVzOiAgICAgICAgICAgJGJvcmRlci1yYWRpdXMgIWRlZmF1bHQ7XG4kYnRuLWJvcmRlci1yYWRpdXMtbGc6ICAgICAgICAkYm9yZGVyLXJhZGl1cy1sZyAhZGVmYXVsdDtcbiRidG4tYm9yZGVyLXJhZGl1cy1zbTogICAgICAgICRib3JkZXItcmFkaXVzLXNtICFkZWZhdWx0O1xuXG4kYnRuLXRyYW5zaXRpb246ICAgICAgICAgICAgICBjb2xvciAuMTVzIGVhc2UtaW4tb3V0LCBiYWNrZ3JvdW5kLWNvbG9yIC4xNXMgZWFzZS1pbi1vdXQsIGJvcmRlci1jb2xvciAuMTVzIGVhc2UtaW4tb3V0LCBib3gtc2hhZG93IC4xNXMgZWFzZS1pbi1vdXQgIWRlZmF1bHQ7XG5cblxuLy8gRm9ybXNcblxuJGxhYmVsLW1hcmdpbi1ib3R0b206ICAgICAgICAgICAgICAgICAgIC41cmVtICFkZWZhdWx0O1xuXG4kaW5wdXQtcGFkZGluZy15OiAgICAgICAgICAgICAgICAgICAgICAgJGlucHV0LWJ0bi1wYWRkaW5nLXkgIWRlZmF1bHQ7XG4kaW5wdXQtcGFkZGluZy14OiAgICAgICAgICAgICAgICAgICAgICAgJGlucHV0LWJ0bi1wYWRkaW5nLXggIWRlZmF1bHQ7XG4kaW5wdXQtZm9udC1mYW1pbHk6ICAgICAgICAgICAgICAgICAgICAgJGlucHV0LWJ0bi1mb250LWZhbWlseSAhZGVmYXVsdDtcbiRpbnB1dC1mb250LXNpemU6ICAgICAgICAgICAgICAgICAgICAgICAkaW5wdXQtYnRuLWZvbnQtc2l6ZSAhZGVmYXVsdDtcbiRpbnB1dC1mb250LXdlaWdodDogICAgICAgICAgICAgICAgICAgICAkZm9udC13ZWlnaHQtYmFzZSAhZGVmYXVsdDtcbiRpbnB1dC1saW5lLWhlaWdodDogICAgICAgICAgICAgICAgICAgICAkaW5wdXQtYnRuLWxpbmUtaGVpZ2h0ICFkZWZhdWx0O1xuXG4kaW5wdXQtcGFkZGluZy15LXNtOiAgICAgICAgICAgICAgICAgICAgJGlucHV0LWJ0bi1wYWRkaW5nLXktc20gIWRlZmF1bHQ7XG4kaW5wdXQtcGFkZGluZy14LXNtOiAgICAgICAgICAgICAgICAgICAgJGlucHV0LWJ0bi1wYWRkaW5nLXgtc20gIWRlZmF1bHQ7XG4kaW5wdXQtZm9udC1zaXplLXNtOiAgICAgICAgICAgICAgICAgICAgJGlucHV0LWJ0bi1mb250LXNpemUtc20gIWRlZmF1bHQ7XG4kaW5wdXQtbGluZS1oZWlnaHQtc206ICAgICAgICAgICAgICAgICAgJGlucHV0LWJ0bi1saW5lLWhlaWdodC1zbSAhZGVmYXVsdDtcblxuJGlucHV0LXBhZGRpbmcteS1sZzogICAgICAgICAgICAgICAgICAgICRpbnB1dC1idG4tcGFkZGluZy15LWxnICFkZWZhdWx0O1xuJGlucHV0LXBhZGRpbmcteC1sZzogICAgICAgICAgICAgICAgICAgICRpbnB1dC1idG4tcGFkZGluZy14LWxnICFkZWZhdWx0O1xuJGlucHV0LWZvbnQtc2l6ZS1sZzogICAgICAgICAgICAgICAgICAgICRpbnB1dC1idG4tZm9udC1zaXplLWxnICFkZWZhdWx0O1xuJGlucHV0LWxpbmUtaGVpZ2h0LWxnOiAgICAgICAgICAgICAgICAgICRpbnB1dC1idG4tbGluZS1oZWlnaHQtbGcgIWRlZmF1bHQ7XG5cbiRpbnB1dC1iZzogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAkd2hpdGUgIWRlZmF1bHQ7XG4kaW5wdXQtZGlzYWJsZWQtYmc6ICAgICAgICAgICAgICAgICAgICAgJGdyYXktMjAwICFkZWZhdWx0O1xuXG4kaW5wdXQtY29sb3I6ICAgICAgICAgICAgICAgICAgICAgICAgICAgJGdyYXktNzAwICFkZWZhdWx0O1xuJGlucHV0LWJvcmRlci1jb2xvcjogICAgICAgICAgICAgICAgICAgICRncmF5LTQwMCAhZGVmYXVsdDtcbiRpbnB1dC1ib3JkZXItd2lkdGg6ICAgICAgICAgICAgICAgICAgICAkaW5wdXQtYnRuLWJvcmRlci13aWR0aCAhZGVmYXVsdDtcbiRpbnB1dC1ib3gtc2hhZG93OiAgICAgICAgICAgICAgICAgICAgICBpbnNldCAwIDFweCAxcHggcmdiYSgkYmxhY2ssIC4wNzUpICFkZWZhdWx0O1xuXG4kaW5wdXQtYm9yZGVyLXJhZGl1czogICAgICAgICAgICAgICAgICAgJGJvcmRlci1yYWRpdXMgIWRlZmF1bHQ7XG4kaW5wdXQtYm9yZGVyLXJhZGl1cy1sZzogICAgICAgICAgICAgICAgJGJvcmRlci1yYWRpdXMtbGcgIWRlZmF1bHQ7XG4kaW5wdXQtYm9yZGVyLXJhZGl1cy1zbTogICAgICAgICAgICAgICAgJGJvcmRlci1yYWRpdXMtc20gIWRlZmF1bHQ7XG5cbiRpbnB1dC1mb2N1cy1iZzogICAgICAgICAgICAgICAgICAgICAgICAkaW5wdXQtYmcgIWRlZmF1bHQ7XG4kaW5wdXQtZm9jdXMtYm9yZGVyLWNvbG9yOiAgICAgICAgICAgICAgbGlnaHRlbigkY29tcG9uZW50LWFjdGl2ZS1iZywgMjUlKSAhZGVmYXVsdDtcbiRpbnB1dC1mb2N1cy1jb2xvcjogICAgICAgICAgICAgICAgICAgICAkaW5wdXQtY29sb3IgIWRlZmF1bHQ7XG4kaW5wdXQtZm9jdXMtd2lkdGg6ICAgICAgICAgICAgICAgICAgICAgJGlucHV0LWJ0bi1mb2N1cy13aWR0aCAhZGVmYXVsdDtcbiRpbnB1dC1mb2N1cy1ib3gtc2hhZG93OiAgICAgICAgICAgICAgICAkaW5wdXQtYnRuLWZvY3VzLWJveC1zaGFkb3cgIWRlZmF1bHQ7XG5cbiRpbnB1dC1wbGFjZWhvbGRlci1jb2xvcjogICAgICAgICAgICAgICAkZ3JheS02MDAgIWRlZmF1bHQ7XG4kaW5wdXQtcGxhaW50ZXh0LWNvbG9yOiAgICAgICAgICAgICAgICAgJGJvZHktY29sb3IgIWRlZmF1bHQ7XG5cbiRpbnB1dC1oZWlnaHQtYm9yZGVyOiAgICAgICAgICAgICAgICAgICAkaW5wdXQtYm9yZGVyLXdpZHRoICogMiAhZGVmYXVsdDtcblxuJGlucHV0LWhlaWdodC1pbm5lcjogICAgICAgICAgICAgICAgICAgIGFkZCgkaW5wdXQtbGluZS1oZWlnaHQgKiAxZW0sICRpbnB1dC1wYWRkaW5nLXkgKiAyKSAhZGVmYXVsdDtcbiRpbnB1dC1oZWlnaHQtaW5uZXItaGFsZjogICAgICAgICAgICAgICBhZGQoJGlucHV0LWxpbmUtaGVpZ2h0ICogLjVlbSwgJGlucHV0LXBhZGRpbmcteSkgIWRlZmF1bHQ7XG4kaW5wdXQtaGVpZ2h0LWlubmVyLXF1YXJ0ZXI6ICAgICAgICAgICAgYWRkKCRpbnB1dC1saW5lLWhlaWdodCAqIC4yNWVtLCAkaW5wdXQtcGFkZGluZy15IC8gMikgIWRlZmF1bHQ7XG5cbiRpbnB1dC1oZWlnaHQ6ICAgICAgICAgICAgICAgICAgICAgICAgICBhZGQoJGlucHV0LWxpbmUtaGVpZ2h0ICogMWVtLCBhZGQoJGlucHV0LXBhZGRpbmcteSAqIDIsICRpbnB1dC1oZWlnaHQtYm9yZGVyLCBmYWxzZSkpICFkZWZhdWx0O1xuJGlucHV0LWhlaWdodC1zbTogICAgICAgICAgICAgICAgICAgICAgIGFkZCgkaW5wdXQtbGluZS1oZWlnaHQtc20gKiAxZW0sIGFkZCgkaW5wdXQtcGFkZGluZy15LXNtICogMiwgJGlucHV0LWhlaWdodC1ib3JkZXIsIGZhbHNlKSkgIWRlZmF1bHQ7XG4kaW5wdXQtaGVpZ2h0LWxnOiAgICAgICAgICAgICAgICAgICAgICAgYWRkKCRpbnB1dC1saW5lLWhlaWdodC1sZyAqIDFlbSwgYWRkKCRpbnB1dC1wYWRkaW5nLXktbGcgKiAyLCAkaW5wdXQtaGVpZ2h0LWJvcmRlciwgZmFsc2UpKSAhZGVmYXVsdDtcblxuJGlucHV0LXRyYW5zaXRpb246ICAgICAgICAgICAgICAgICAgICAgIGJvcmRlci1jb2xvciAuMTVzIGVhc2UtaW4tb3V0LCBib3gtc2hhZG93IC4xNXMgZWFzZS1pbi1vdXQgIWRlZmF1bHQ7XG5cbiRmb3JtLXRleHQtbWFyZ2luLXRvcDogICAgICAgICAgICAgICAgICAuMjVyZW0gIWRlZmF1bHQ7XG5cbiRmb3JtLWNoZWNrLWlucHV0LWd1dHRlcjogICAgICAgICAgICAgICAxLjI1cmVtICFkZWZhdWx0O1xuJGZvcm0tY2hlY2staW5wdXQtbWFyZ2luLXk6ICAgICAgICAgICAgIC4zcmVtICFkZWZhdWx0O1xuJGZvcm0tY2hlY2staW5wdXQtbWFyZ2luLXg6ICAgICAgICAgICAgIC4yNXJlbSAhZGVmYXVsdDtcblxuJGZvcm0tY2hlY2staW5saW5lLW1hcmdpbi14OiAgICAgICAgICAgIC43NXJlbSAhZGVmYXVsdDtcbiRmb3JtLWNoZWNrLWlubGluZS1pbnB1dC1tYXJnaW4teDogICAgICAuMzEyNXJlbSAhZGVmYXVsdDtcblxuJGZvcm0tZ3JpZC1ndXR0ZXItd2lkdGg6ICAgICAgICAgICAgICAgIDEwcHggIWRlZmF1bHQ7XG4kZm9ybS1ncm91cC1tYXJnaW4tYm90dG9tOiAgICAgICAgICAgICAgMXJlbSAhZGVmYXVsdDtcblxuJGlucHV0LWdyb3VwLWFkZG9uLWNvbG9yOiAgICAgICAgICAgICAgICRpbnB1dC1jb2xvciAhZGVmYXVsdDtcbiRpbnB1dC1ncm91cC1hZGRvbi1iZzogICAgICAgICAgICAgICAgICAkZ3JheS0yMDAgIWRlZmF1bHQ7XG4kaW5wdXQtZ3JvdXAtYWRkb24tYm9yZGVyLWNvbG9yOiAgICAgICAgJGlucHV0LWJvcmRlci1jb2xvciAhZGVmYXVsdDtcblxuJGN1c3RvbS1mb3Jtcy10cmFuc2l0aW9uOiAgICAgICAgICAgICAgIGJhY2tncm91bmQtY29sb3IgLjE1cyBlYXNlLWluLW91dCwgYm9yZGVyLWNvbG9yIC4xNXMgZWFzZS1pbi1vdXQsIGJveC1zaGFkb3cgLjE1cyBlYXNlLWluLW91dCAhZGVmYXVsdDtcblxuJGN1c3RvbS1jb250cm9sLWd1dHRlcjogICAgICAgICAgICAgICAgIC41cmVtICFkZWZhdWx0O1xuJGN1c3RvbS1jb250cm9sLXNwYWNlci14OiAgICAgICAgICAgICAgIDFyZW0gIWRlZmF1bHQ7XG4kY3VzdG9tLWNvbnRyb2wtY3Vyc29yOiAgICAgICAgICAgICAgICAgbnVsbCAhZGVmYXVsdDtcblxuJGN1c3RvbS1jb250cm9sLWluZGljYXRvci1zaXplOiAgICAgICAgIDFyZW0gIWRlZmF1bHQ7XG4kY3VzdG9tLWNvbnRyb2wtaW5kaWNhdG9yLWJnOiAgICAgICAgICAgJGlucHV0LWJnICFkZWZhdWx0O1xuXG4kY3VzdG9tLWNvbnRyb2wtaW5kaWNhdG9yLWJnLXNpemU6ICAgICAgNTAlIDUwJSAhZGVmYXVsdDtcbiRjdXN0b20tY29udHJvbC1pbmRpY2F0b3ItYm94LXNoYWRvdzogICAkaW5wdXQtYm94LXNoYWRvdyAhZGVmYXVsdDtcbiRjdXN0b20tY29udHJvbC1pbmRpY2F0b3ItYm9yZGVyLWNvbG9yOiAkZ3JheS01MDAgIWRlZmF1bHQ7XG4kY3VzdG9tLWNvbnRyb2wtaW5kaWNhdG9yLWJvcmRlci13aWR0aDogJGlucHV0LWJvcmRlci13aWR0aCAhZGVmYXVsdDtcblxuJGN1c3RvbS1jb250cm9sLWxhYmVsLWNvbG9yOiAgICAgICAgICAgIG51bGwgIWRlZmF1bHQ7XG5cbiRjdXN0b20tY29udHJvbC1pbmRpY2F0b3ItZGlzYWJsZWQtYmc6ICAgICAgICAgICRpbnB1dC1kaXNhYmxlZC1iZyAhZGVmYXVsdDtcbiRjdXN0b20tY29udHJvbC1sYWJlbC1kaXNhYmxlZC1jb2xvcjogICAgICAgICAgICRncmF5LTYwMCAhZGVmYXVsdDtcblxuJGN1c3RvbS1jb250cm9sLWluZGljYXRvci1jaGVja2VkLWNvbG9yOiAgICAgICAgJGNvbXBvbmVudC1hY3RpdmUtY29sb3IgIWRlZmF1bHQ7XG4kY3VzdG9tLWNvbnRyb2wtaW5kaWNhdG9yLWNoZWNrZWQtYmc6ICAgICAgICAgICAkY29tcG9uZW50LWFjdGl2ZS1iZyAhZGVmYXVsdDtcbiRjdXN0b20tY29udHJvbC1pbmRpY2F0b3ItY2hlY2tlZC1kaXNhYmxlZC1iZzogIHJnYmEodGhlbWUtY29sb3IoXCJwcmltYXJ5XCIpLCAuNSkgIWRlZmF1bHQ7XG4kY3VzdG9tLWNvbnRyb2wtaW5kaWNhdG9yLWNoZWNrZWQtYm94LXNoYWRvdzogICBub25lICFkZWZhdWx0O1xuJGN1c3RvbS1jb250cm9sLWluZGljYXRvci1jaGVja2VkLWJvcmRlci1jb2xvcjogJGN1c3RvbS1jb250cm9sLWluZGljYXRvci1jaGVja2VkLWJnICFkZWZhdWx0O1xuXG4kY3VzdG9tLWNvbnRyb2wtaW5kaWNhdG9yLWZvY3VzLWJveC1zaGFkb3c6ICAgICAkaW5wdXQtZm9jdXMtYm94LXNoYWRvdyAhZGVmYXVsdDtcbiRjdXN0b20tY29udHJvbC1pbmRpY2F0b3ItZm9jdXMtYm9yZGVyLWNvbG9yOiAgICRpbnB1dC1mb2N1cy1ib3JkZXItY29sb3IgIWRlZmF1bHQ7XG5cbiRjdXN0b20tY29udHJvbC1pbmRpY2F0b3ItYWN0aXZlLWNvbG9yOiAgICAgICAgICRjb21wb25lbnQtYWN0aXZlLWNvbG9yICFkZWZhdWx0O1xuJGN1c3RvbS1jb250cm9sLWluZGljYXRvci1hY3RpdmUtYmc6ICAgICAgICAgICAgbGlnaHRlbigkY29tcG9uZW50LWFjdGl2ZS1iZywgMzUlKSAhZGVmYXVsdDtcbiRjdXN0b20tY29udHJvbC1pbmRpY2F0b3ItYWN0aXZlLWJveC1zaGFkb3c6ICAgIG5vbmUgIWRlZmF1bHQ7XG4kY3VzdG9tLWNvbnRyb2wtaW5kaWNhdG9yLWFjdGl2ZS1ib3JkZXItY29sb3I6ICAkY3VzdG9tLWNvbnRyb2wtaW5kaWNhdG9yLWFjdGl2ZS1iZyAhZGVmYXVsdDtcblxuJGN1c3RvbS1jaGVja2JveC1pbmRpY2F0b3ItYm9yZGVyLXJhZGl1czogICAgICAgJGJvcmRlci1yYWRpdXMgIWRlZmF1bHQ7XG4kY3VzdG9tLWNoZWNrYm94LWluZGljYXRvci1pY29uLWNoZWNrZWQ6ICAgICAgICB1cmwoXCJkYXRhOmltYWdlL3N2Zyt4bWwsPHN2ZyB4bWxucz0naHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmcnIHdpZHRoPSc4JyBoZWlnaHQ9JzgnIHZpZXdCb3g9JzAgMCA4IDgnPjxwYXRoIGZpbGw9JyN7JGN1c3RvbS1jb250cm9sLWluZGljYXRvci1jaGVja2VkLWNvbG9yfScgZD0nTTYuNTY0Ljc1bC0zLjU5IDMuNjEyLTEuNTM4LTEuNTVMMCA0LjI2bDIuOTc0IDIuOTlMOCAyLjE5M3onLz48L3N2Zz5cIikgIWRlZmF1bHQ7XG5cbiRjdXN0b20tY2hlY2tib3gtaW5kaWNhdG9yLWluZGV0ZXJtaW5hdGUtYmc6ICAgICAgICAgICAkY29tcG9uZW50LWFjdGl2ZS1iZyAhZGVmYXVsdDtcbiRjdXN0b20tY2hlY2tib3gtaW5kaWNhdG9yLWluZGV0ZXJtaW5hdGUtY29sb3I6ICAgICAgICAkY3VzdG9tLWNvbnRyb2wtaW5kaWNhdG9yLWNoZWNrZWQtY29sb3IgIWRlZmF1bHQ7XG4kY3VzdG9tLWNoZWNrYm94LWluZGljYXRvci1pY29uLWluZGV0ZXJtaW5hdGU6ICAgICAgICAgdXJsKFwiZGF0YTppbWFnZS9zdmcreG1sLDxzdmcgeG1sbnM9J2h0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnJyB3aWR0aD0nNCcgaGVpZ2h0PSc0JyB2aWV3Qm94PScwIDAgNCA0Jz48cGF0aCBzdHJva2U9JyN7JGN1c3RvbS1jaGVja2JveC1pbmRpY2F0b3ItaW5kZXRlcm1pbmF0ZS1jb2xvcn0nIGQ9J00wIDJoNCcvPjwvc3ZnPlwiKSAhZGVmYXVsdDtcbiRjdXN0b20tY2hlY2tib3gtaW5kaWNhdG9yLWluZGV0ZXJtaW5hdGUtYm94LXNoYWRvdzogICBub25lICFkZWZhdWx0O1xuJGN1c3RvbS1jaGVja2JveC1pbmRpY2F0b3ItaW5kZXRlcm1pbmF0ZS1ib3JkZXItY29sb3I6ICRjdXN0b20tY2hlY2tib3gtaW5kaWNhdG9yLWluZGV0ZXJtaW5hdGUtYmcgIWRlZmF1bHQ7XG5cbiRjdXN0b20tcmFkaW8taW5kaWNhdG9yLWJvcmRlci1yYWRpdXM6ICAgICAgICAgIDUwJSAhZGVmYXVsdDtcbiRjdXN0b20tcmFkaW8taW5kaWNhdG9yLWljb24tY2hlY2tlZDogICAgICAgICAgIHVybChcImRhdGE6aW1hZ2Uvc3ZnK3htbCw8c3ZnIHhtbG5zPSdodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2Zycgd2lkdGg9JzEyJyBoZWlnaHQ9JzEyJyB2aWV3Qm94PSctNCAtNCA4IDgnPjxjaXJjbGUgcj0nMycgZmlsbD0nI3skY3VzdG9tLWNvbnRyb2wtaW5kaWNhdG9yLWNoZWNrZWQtY29sb3J9Jy8+PC9zdmc+XCIpICFkZWZhdWx0O1xuXG4kY3VzdG9tLXN3aXRjaC13aWR0aDogICAgICAgICAgICAgICAgICAgICAgICAgICAkY3VzdG9tLWNvbnRyb2wtaW5kaWNhdG9yLXNpemUgKiAxLjc1ICFkZWZhdWx0O1xuJGN1c3RvbS1zd2l0Y2gtaW5kaWNhdG9yLWJvcmRlci1yYWRpdXM6ICAgICAgICAgJGN1c3RvbS1jb250cm9sLWluZGljYXRvci1zaXplIC8gMiAhZGVmYXVsdDtcbiRjdXN0b20tc3dpdGNoLWluZGljYXRvci1zaXplOiAgICAgICAgICAgICAgICAgIHN1YnRyYWN0KCRjdXN0b20tY29udHJvbC1pbmRpY2F0b3Itc2l6ZSwgJGN1c3RvbS1jb250cm9sLWluZGljYXRvci1ib3JkZXItd2lkdGggKiA0KSAhZGVmYXVsdDtcblxuJGN1c3RvbS1zZWxlY3QtcGFkZGluZy15OiAgICAgICAgICAgJGlucHV0LXBhZGRpbmcteSAhZGVmYXVsdDtcbiRjdXN0b20tc2VsZWN0LXBhZGRpbmcteDogICAgICAgICAgICRpbnB1dC1wYWRkaW5nLXggIWRlZmF1bHQ7XG4kY3VzdG9tLXNlbGVjdC1mb250LWZhbWlseTogICAgICAgICAkaW5wdXQtZm9udC1mYW1pbHkgIWRlZmF1bHQ7XG4kY3VzdG9tLXNlbGVjdC1mb250LXNpemU6ICAgICAgICAgICAkaW5wdXQtZm9udC1zaXplICFkZWZhdWx0O1xuJGN1c3RvbS1zZWxlY3QtaGVpZ2h0OiAgICAgICAgICAgICAgJGlucHV0LWhlaWdodCAhZGVmYXVsdDtcbiRjdXN0b20tc2VsZWN0LWluZGljYXRvci1wYWRkaW5nOiAgIDFyZW0gIWRlZmF1bHQ7IC8vIEV4dHJhIHBhZGRpbmcgdG8gYWNjb3VudCBmb3IgdGhlIHByZXNlbmNlIG9mIHRoZSBiYWNrZ3JvdW5kLWltYWdlIGJhc2VkIGluZGljYXRvclxuJGN1c3RvbS1zZWxlY3QtZm9udC13ZWlnaHQ6ICAgICAgICAgJGlucHV0LWZvbnQtd2VpZ2h0ICFkZWZhdWx0O1xuJGN1c3RvbS1zZWxlY3QtbGluZS1oZWlnaHQ6ICAgICAgICAgJGlucHV0LWxpbmUtaGVpZ2h0ICFkZWZhdWx0O1xuJGN1c3RvbS1zZWxlY3QtY29sb3I6ICAgICAgICAgICAgICAgJGlucHV0LWNvbG9yICFkZWZhdWx0O1xuJGN1c3RvbS1zZWxlY3QtZGlzYWJsZWQtY29sb3I6ICAgICAgJGdyYXktNjAwICFkZWZhdWx0O1xuJGN1c3RvbS1zZWxlY3QtYmc6ICAgICAgICAgICAgICAgICAgJGlucHV0LWJnICFkZWZhdWx0O1xuJGN1c3RvbS1zZWxlY3QtZGlzYWJsZWQtYmc6ICAgICAgICAgJGdyYXktMjAwICFkZWZhdWx0O1xuJGN1c3RvbS1zZWxlY3QtYmctc2l6ZTogICAgICAgICAgICAgOHB4IDEwcHggIWRlZmF1bHQ7IC8vIEluIHBpeGVscyBiZWNhdXNlIGltYWdlIGRpbWVuc2lvbnNcbiRjdXN0b20tc2VsZWN0LWluZGljYXRvci1jb2xvcjogICAgICRncmF5LTgwMCAhZGVmYXVsdDtcbiRjdXN0b20tc2VsZWN0LWluZGljYXRvcjogICAgICAgICAgIHVybChcImRhdGE6aW1hZ2Uvc3ZnK3htbCw8c3ZnIHhtbG5zPSdodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2Zycgd2lkdGg9JzQnIGhlaWdodD0nNScgdmlld0JveD0nMCAwIDQgNSc+PHBhdGggZmlsbD0nI3skY3VzdG9tLXNlbGVjdC1pbmRpY2F0b3ItY29sb3J9JyBkPSdNMiAwTDAgMmg0em0wIDVMMCAzaDR6Jy8+PC9zdmc+XCIpICFkZWZhdWx0O1xuJGN1c3RvbS1zZWxlY3QtYmFja2dyb3VuZDogICAgICAgICAgZXNjYXBlLXN2ZygkY3VzdG9tLXNlbGVjdC1pbmRpY2F0b3IpIG5vLXJlcGVhdCByaWdodCAkY3VzdG9tLXNlbGVjdC1wYWRkaW5nLXggY2VudGVyIC8gJGN1c3RvbS1zZWxlY3QtYmctc2l6ZSAhZGVmYXVsdDsgLy8gVXNlZCBzbyB3ZSBjYW4gaGF2ZSBtdWx0aXBsZSBiYWNrZ3JvdW5kIGVsZW1lbnRzIChlLmcuLCBhcnJvdyBhbmQgZmVlZGJhY2sgaWNvbilcblxuJGN1c3RvbS1zZWxlY3QtZmVlZGJhY2staWNvbi1wYWRkaW5nLXJpZ2h0OiBhZGQoMWVtICogLjc1LCAoMiAqICRjdXN0b20tc2VsZWN0LXBhZGRpbmcteSAqIC43NSkgKyAkY3VzdG9tLXNlbGVjdC1wYWRkaW5nLXggKyAkY3VzdG9tLXNlbGVjdC1pbmRpY2F0b3ItcGFkZGluZykgIWRlZmF1bHQ7XG4kY3VzdG9tLXNlbGVjdC1mZWVkYmFjay1pY29uLXBvc2l0aW9uOiAgICAgIGNlbnRlciByaWdodCAoJGN1c3RvbS1zZWxlY3QtcGFkZGluZy14ICsgJGN1c3RvbS1zZWxlY3QtaW5kaWNhdG9yLXBhZGRpbmcpICFkZWZhdWx0O1xuJGN1c3RvbS1zZWxlY3QtZmVlZGJhY2staWNvbi1zaXplOiAgICAgICAgICAkaW5wdXQtaGVpZ2h0LWlubmVyLWhhbGYgJGlucHV0LWhlaWdodC1pbm5lci1oYWxmICFkZWZhdWx0O1xuXG4kY3VzdG9tLXNlbGVjdC1ib3JkZXItd2lkdGg6ICAgICAgICAkaW5wdXQtYm9yZGVyLXdpZHRoICFkZWZhdWx0O1xuJGN1c3RvbS1zZWxlY3QtYm9yZGVyLWNvbG9yOiAgICAgICAgJGlucHV0LWJvcmRlci1jb2xvciAhZGVmYXVsdDtcbiRjdXN0b20tc2VsZWN0LWJvcmRlci1yYWRpdXM6ICAgICAgICRib3JkZXItcmFkaXVzICFkZWZhdWx0O1xuJGN1c3RvbS1zZWxlY3QtYm94LXNoYWRvdzogICAgICAgICAgaW5zZXQgMCAxcHggMnB4IHJnYmEoJGJsYWNrLCAuMDc1KSAhZGVmYXVsdDtcblxuJGN1c3RvbS1zZWxlY3QtZm9jdXMtYm9yZGVyLWNvbG9yOiAgJGlucHV0LWZvY3VzLWJvcmRlci1jb2xvciAhZGVmYXVsdDtcbiRjdXN0b20tc2VsZWN0LWZvY3VzLXdpZHRoOiAgICAgICAgICRpbnB1dC1mb2N1cy13aWR0aCAhZGVmYXVsdDtcbiRjdXN0b20tc2VsZWN0LWZvY3VzLWJveC1zaGFkb3c6ICAgIDAgMCAwICRjdXN0b20tc2VsZWN0LWZvY3VzLXdpZHRoICRpbnB1dC1idG4tZm9jdXMtY29sb3IgIWRlZmF1bHQ7XG5cbiRjdXN0b20tc2VsZWN0LXBhZGRpbmcteS1zbTogICAgICAgICRpbnB1dC1wYWRkaW5nLXktc20gIWRlZmF1bHQ7XG4kY3VzdG9tLXNlbGVjdC1wYWRkaW5nLXgtc206ICAgICAgICAkaW5wdXQtcGFkZGluZy14LXNtICFkZWZhdWx0O1xuJGN1c3RvbS1zZWxlY3QtZm9udC1zaXplLXNtOiAgICAgICAgJGlucHV0LWZvbnQtc2l6ZS1zbSAhZGVmYXVsdDtcbiRjdXN0b20tc2VsZWN0LWhlaWdodC1zbTogICAgICAgICAgICRpbnB1dC1oZWlnaHQtc20gIWRlZmF1bHQ7XG5cbiRjdXN0b20tc2VsZWN0LXBhZGRpbmcteS1sZzogICAgICAgICRpbnB1dC1wYWRkaW5nLXktbGcgIWRlZmF1bHQ7XG4kY3VzdG9tLXNlbGVjdC1wYWRkaW5nLXgtbGc6ICAgICAgICAkaW5wdXQtcGFkZGluZy14LWxnICFkZWZhdWx0O1xuJGN1c3RvbS1zZWxlY3QtZm9udC1zaXplLWxnOiAgICAgICAgJGlucHV0LWZvbnQtc2l6ZS1sZyAhZGVmYXVsdDtcbiRjdXN0b20tc2VsZWN0LWhlaWdodC1sZzogICAgICAgICAgICRpbnB1dC1oZWlnaHQtbGcgIWRlZmF1bHQ7XG5cbiRjdXN0b20tcmFuZ2UtdHJhY2std2lkdGg6ICAgICAgICAgIDEwMCUgIWRlZmF1bHQ7XG4kY3VzdG9tLXJhbmdlLXRyYWNrLWhlaWdodDogICAgICAgICAuNXJlbSAhZGVmYXVsdDtcbiRjdXN0b20tcmFuZ2UtdHJhY2stY3Vyc29yOiAgICAgICAgIHBvaW50ZXIgIWRlZmF1bHQ7XG4kY3VzdG9tLXJhbmdlLXRyYWNrLWJnOiAgICAgICAgICAgICAkZ3JheS0zMDAgIWRlZmF1bHQ7XG4kY3VzdG9tLXJhbmdlLXRyYWNrLWJvcmRlci1yYWRpdXM6ICAxcmVtICFkZWZhdWx0O1xuJGN1c3RvbS1yYW5nZS10cmFjay1ib3gtc2hhZG93OiAgICAgaW5zZXQgMCAuMjVyZW0gLjI1cmVtIHJnYmEoJGJsYWNrLCAuMSkgIWRlZmF1bHQ7XG5cbiRjdXN0b20tcmFuZ2UtdGh1bWItd2lkdGg6ICAgICAgICAgICAgICAgICAgIDFyZW0gIWRlZmF1bHQ7XG4kY3VzdG9tLXJhbmdlLXRodW1iLWhlaWdodDogICAgICAgICAgICAgICAgICAkY3VzdG9tLXJhbmdlLXRodW1iLXdpZHRoICFkZWZhdWx0O1xuJGN1c3RvbS1yYW5nZS10aHVtYi1iZzogICAgICAgICAgICAgICAgICAgICAgJGNvbXBvbmVudC1hY3RpdmUtYmcgIWRlZmF1bHQ7XG4kY3VzdG9tLXJhbmdlLXRodW1iLWJvcmRlcjogICAgICAgICAgICAgICAgICAwICFkZWZhdWx0O1xuJGN1c3RvbS1yYW5nZS10aHVtYi1ib3JkZXItcmFkaXVzOiAgICAgICAgICAgMXJlbSAhZGVmYXVsdDtcbiRjdXN0b20tcmFuZ2UtdGh1bWItYm94LXNoYWRvdzogICAgICAgICAgICAgIDAgLjFyZW0gLjI1cmVtIHJnYmEoJGJsYWNrLCAuMSkgIWRlZmF1bHQ7XG4kY3VzdG9tLXJhbmdlLXRodW1iLWZvY3VzLWJveC1zaGFkb3c6ICAgICAgICAwIDAgMCAxcHggJGJvZHktYmcsICRpbnB1dC1mb2N1cy1ib3gtc2hhZG93ICFkZWZhdWx0O1xuJGN1c3RvbS1yYW5nZS10aHVtYi1mb2N1cy1ib3gtc2hhZG93LXdpZHRoOiAgJGlucHV0LWZvY3VzLXdpZHRoICFkZWZhdWx0OyAvLyBGb3IgZm9jdXMgYm94IHNoYWRvdyBpc3N1ZSBpbiBJRS9FZGdlXG4kY3VzdG9tLXJhbmdlLXRodW1iLWFjdGl2ZS1iZzogICAgICAgICAgICAgICBsaWdodGVuKCRjb21wb25lbnQtYWN0aXZlLWJnLCAzNSUpICFkZWZhdWx0O1xuJGN1c3RvbS1yYW5nZS10aHVtYi1kaXNhYmxlZC1iZzogICAgICAgICAgICAgJGdyYXktNTAwICFkZWZhdWx0O1xuXG4kY3VzdG9tLWZpbGUtaGVpZ2h0OiAgICAgICAgICAgICAgICAkaW5wdXQtaGVpZ2h0ICFkZWZhdWx0O1xuJGN1c3RvbS1maWxlLWhlaWdodC1pbm5lcjogICAgICAgICAgJGlucHV0LWhlaWdodC1pbm5lciAhZGVmYXVsdDtcbiRjdXN0b20tZmlsZS1mb2N1cy1ib3JkZXItY29sb3I6ICAgICRpbnB1dC1mb2N1cy1ib3JkZXItY29sb3IgIWRlZmF1bHQ7XG4kY3VzdG9tLWZpbGUtZm9jdXMtYm94LXNoYWRvdzogICAgICAkaW5wdXQtZm9jdXMtYm94LXNoYWRvdyAhZGVmYXVsdDtcbiRjdXN0b20tZmlsZS1kaXNhYmxlZC1iZzogICAgICAgICAgICRpbnB1dC1kaXNhYmxlZC1iZyAhZGVmYXVsdDtcblxuJGN1c3RvbS1maWxlLXBhZGRpbmcteTogICAgICAgICAgICAgJGlucHV0LXBhZGRpbmcteSAhZGVmYXVsdDtcbiRjdXN0b20tZmlsZS1wYWRkaW5nLXg6ICAgICAgICAgICAgICRpbnB1dC1wYWRkaW5nLXggIWRlZmF1bHQ7XG4kY3VzdG9tLWZpbGUtbGluZS1oZWlnaHQ6ICAgICAgICAgICAkaW5wdXQtbGluZS1oZWlnaHQgIWRlZmF1bHQ7XG4kY3VzdG9tLWZpbGUtZm9udC1mYW1pbHk6ICAgICAgICAgICAkaW5wdXQtZm9udC1mYW1pbHkgIWRlZmF1bHQ7XG4kY3VzdG9tLWZpbGUtZm9udC13ZWlnaHQ6ICAgICAgICAgICAkaW5wdXQtZm9udC13ZWlnaHQgIWRlZmF1bHQ7XG4kY3VzdG9tLWZpbGUtY29sb3I6ICAgICAgICAgICAgICAgICAkaW5wdXQtY29sb3IgIWRlZmF1bHQ7XG4kY3VzdG9tLWZpbGUtYmc6ICAgICAgICAgICAgICAgICAgICAkaW5wdXQtYmcgIWRlZmF1bHQ7XG4kY3VzdG9tLWZpbGUtYm9yZGVyLXdpZHRoOiAgICAgICAgICAkaW5wdXQtYm9yZGVyLXdpZHRoICFkZWZhdWx0O1xuJGN1c3RvbS1maWxlLWJvcmRlci1jb2xvcjogICAgICAgICAgJGlucHV0LWJvcmRlci1jb2xvciAhZGVmYXVsdDtcbiRjdXN0b20tZmlsZS1ib3JkZXItcmFkaXVzOiAgICAgICAgICRpbnB1dC1ib3JkZXItcmFkaXVzICFkZWZhdWx0O1xuJGN1c3RvbS1maWxlLWJveC1zaGFkb3c6ICAgICAgICAgICAgJGlucHV0LWJveC1zaGFkb3cgIWRlZmF1bHQ7XG4kY3VzdG9tLWZpbGUtYnV0dG9uLWNvbG9yOiAgICAgICAgICAkY3VzdG9tLWZpbGUtY29sb3IgIWRlZmF1bHQ7XG4kY3VzdG9tLWZpbGUtYnV0dG9uLWJnOiAgICAgICAgICAgICAkaW5wdXQtZ3JvdXAtYWRkb24tYmcgIWRlZmF1bHQ7XG4kY3VzdG9tLWZpbGUtdGV4dDogKFxuICBlbjogXCJCcm93c2VcIlxuKSAhZGVmYXVsdDtcblxuXG4vLyBGb3JtIHZhbGlkYXRpb25cblxuJGZvcm0tZmVlZGJhY2stbWFyZ2luLXRvcDogICAgICAgICAgJGZvcm0tdGV4dC1tYXJnaW4tdG9wICFkZWZhdWx0O1xuJGZvcm0tZmVlZGJhY2stZm9udC1zaXplOiAgICAgICAgICAgJHNtYWxsLWZvbnQtc2l6ZSAhZGVmYXVsdDtcbiRmb3JtLWZlZWRiYWNrLXZhbGlkLWNvbG9yOiAgICAgICAgIHRoZW1lLWNvbG9yKFwic3VjY2Vzc1wiKSAhZGVmYXVsdDtcbiRmb3JtLWZlZWRiYWNrLWludmFsaWQtY29sb3I6ICAgICAgIHRoZW1lLWNvbG9yKFwiZGFuZ2VyXCIpICFkZWZhdWx0O1xuXG4kZm9ybS1mZWVkYmFjay1pY29uLXZhbGlkLWNvbG9yOiAgICAkZm9ybS1mZWVkYmFjay12YWxpZC1jb2xvciAhZGVmYXVsdDtcbiRmb3JtLWZlZWRiYWNrLWljb24tdmFsaWQ6ICAgICAgICAgIHVybChcImRhdGE6aW1hZ2Uvc3ZnK3htbCw8c3ZnIHhtbG5zPSdodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2Zycgd2lkdGg9JzgnIGhlaWdodD0nOCcgdmlld0JveD0nMCAwIDggOCc+PHBhdGggZmlsbD0nI3skZm9ybS1mZWVkYmFjay1pY29uLXZhbGlkLWNvbG9yfScgZD0nTTIuMyA2LjczTC42IDQuNTNjLS40LTEuMDQuNDYtMS40IDEuMS0uOGwxLjEgMS40IDMuNC0zLjhjLjYtLjYzIDEuNi0uMjcgMS4yLjdsLTQgNC42Yy0uNDMuNS0uOC40LTEuMS4xeicvPjwvc3ZnPlwiKSAhZGVmYXVsdDtcbiRmb3JtLWZlZWRiYWNrLWljb24taW52YWxpZC1jb2xvcjogICRmb3JtLWZlZWRiYWNrLWludmFsaWQtY29sb3IgIWRlZmF1bHQ7XG4kZm9ybS1mZWVkYmFjay1pY29uLWludmFsaWQ6ICAgICAgICB1cmwoXCJkYXRhOmltYWdlL3N2Zyt4bWwsPHN2ZyB4bWxucz0naHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmcnIHdpZHRoPScxMicgaGVpZ2h0PScxMicgZmlsbD0nbm9uZScgc3Ryb2tlPScjeyRmb3JtLWZlZWRiYWNrLWljb24taW52YWxpZC1jb2xvcn0nIHZpZXdCb3g9JzAgMCAxMiAxMic+PGNpcmNsZSBjeD0nNicgY3k9JzYnIHI9JzQuNScvPjxwYXRoIHN0cm9rZS1saW5lam9pbj0ncm91bmQnIGQ9J001LjggMy42aC40TDYgNi41eicvPjxjaXJjbGUgY3g9JzYnIGN5PSc4LjInIHI9Jy42JyBmaWxsPScjeyRmb3JtLWZlZWRiYWNrLWljb24taW52YWxpZC1jb2xvcn0nIHN0cm9rZT0nbm9uZScvPjwvc3ZnPlwiKSAhZGVmYXVsdDtcblxuJGZvcm0tdmFsaWRhdGlvbi1zdGF0ZXM6ICgpICFkZWZhdWx0O1xuLy8gc3R5bGVsaW50LWRpc2FibGUtbmV4dC1saW5lIHNjc3MvZG9sbGFyLXZhcmlhYmxlLWRlZmF1bHRcbiRmb3JtLXZhbGlkYXRpb24tc3RhdGVzOiBtYXAtbWVyZ2UoXG4gIChcbiAgICBcInZhbGlkXCI6IChcbiAgICAgIFwiY29sb3JcIjogJGZvcm0tZmVlZGJhY2stdmFsaWQtY29sb3IsXG4gICAgICBcImljb25cIjogJGZvcm0tZmVlZGJhY2staWNvbi12YWxpZFxuICAgICksXG4gICAgXCJpbnZhbGlkXCI6IChcbiAgICAgIFwiY29sb3JcIjogJGZvcm0tZmVlZGJhY2staW52YWxpZC1jb2xvcixcbiAgICAgIFwiaWNvblwiOiAkZm9ybS1mZWVkYmFjay1pY29uLWludmFsaWRcbiAgICApLFxuICApLFxuICAkZm9ybS12YWxpZGF0aW9uLXN0YXRlc1xuKTtcblxuLy8gWi1pbmRleCBtYXN0ZXIgbGlzdFxuLy9cbi8vIFdhcm5pbmc6IEF2b2lkIGN1c3RvbWl6aW5nIHRoZXNlIHZhbHVlcy4gVGhleSdyZSB1c2VkIGZvciBhIGJpcmQncyBleWUgdmlld1xuLy8gb2YgY29tcG9uZW50cyBkZXBlbmRlbnQgb24gdGhlIHotYXhpcyBhbmQgYXJlIGRlc2lnbmVkIHRvIGFsbCB3b3JrIHRvZ2V0aGVyLlxuXG4kemluZGV4LWRyb3Bkb3duOiAgICAgICAgICAgICAgICAgICAxMDAwICFkZWZhdWx0O1xuJHppbmRleC1zdGlja3k6ICAgICAgICAgICAgICAgICAgICAgMTAyMCAhZGVmYXVsdDtcbiR6aW5kZXgtZml4ZWQ6ICAgICAgICAgICAgICAgICAgICAgIDEwMzAgIWRlZmF1bHQ7XG4kemluZGV4LW1vZGFsLWJhY2tkcm9wOiAgICAgICAgICAgICAxMDQwICFkZWZhdWx0O1xuJHppbmRleC1tb2RhbDogICAgICAgICAgICAgICAgICAgICAgMTA1MCAhZGVmYXVsdDtcbiR6aW5kZXgtcG9wb3ZlcjogICAgICAgICAgICAgICAgICAgIDEwNjAgIWRlZmF1bHQ7XG4kemluZGV4LXRvb2x0aXA6ICAgICAgICAgICAgICAgICAgICAxMDcwICFkZWZhdWx0O1xuXG5cbi8vIE5hdnNcblxuJG5hdi1saW5rLXBhZGRpbmcteTogICAgICAgICAgICAgICAgLjVyZW0gIWRlZmF1bHQ7XG4kbmF2LWxpbmstcGFkZGluZy14OiAgICAgICAgICAgICAgICAxcmVtICFkZWZhdWx0O1xuJG5hdi1saW5rLWRpc2FibGVkLWNvbG9yOiAgICAgICAgICAgJGdyYXktNjAwICFkZWZhdWx0O1xuXG4kbmF2LXRhYnMtYm9yZGVyLWNvbG9yOiAgICAgICAgICAgICAkZ3JheS0zMDAgIWRlZmF1bHQ7XG4kbmF2LXRhYnMtYm9yZGVyLXdpZHRoOiAgICAgICAgICAgICAkYm9yZGVyLXdpZHRoICFkZWZhdWx0O1xuJG5hdi10YWJzLWJvcmRlci1yYWRpdXM6ICAgICAgICAgICAgJGJvcmRlci1yYWRpdXMgIWRlZmF1bHQ7XG4kbmF2LXRhYnMtbGluay1ob3Zlci1ib3JkZXItY29sb3I6ICAkZ3JheS0yMDAgJGdyYXktMjAwICRuYXYtdGFicy1ib3JkZXItY29sb3IgIWRlZmF1bHQ7XG4kbmF2LXRhYnMtbGluay1hY3RpdmUtY29sb3I6ICAgICAgICAkZ3JheS03MDAgIWRlZmF1bHQ7XG4kbmF2LXRhYnMtbGluay1hY3RpdmUtYmc6ICAgICAgICAgICAkYm9keS1iZyAhZGVmYXVsdDtcbiRuYXYtdGFicy1saW5rLWFjdGl2ZS1ib3JkZXItY29sb3I6ICRncmF5LTMwMCAkZ3JheS0zMDAgJG5hdi10YWJzLWxpbmstYWN0aXZlLWJnICFkZWZhdWx0O1xuXG4kbmF2LXBpbGxzLWJvcmRlci1yYWRpdXM6ICAgICAgICAgICAkYm9yZGVyLXJhZGl1cyAhZGVmYXVsdDtcbiRuYXYtcGlsbHMtbGluay1hY3RpdmUtY29sb3I6ICAgICAgICRjb21wb25lbnQtYWN0aXZlLWNvbG9yICFkZWZhdWx0O1xuJG5hdi1waWxscy1saW5rLWFjdGl2ZS1iZzogICAgICAgICAgJGNvbXBvbmVudC1hY3RpdmUtYmcgIWRlZmF1bHQ7XG5cbiRuYXYtZGl2aWRlci1jb2xvcjogICAgICAgICAgICAgICAgICRncmF5LTIwMCAhZGVmYXVsdDtcbiRuYXYtZGl2aWRlci1tYXJnaW4teTogICAgICAgICAgICAgICRzcGFjZXIgLyAyICFkZWZhdWx0O1xuXG5cbi8vIE5hdmJhclxuXG4kbmF2YmFyLXBhZGRpbmcteTogICAgICAgICAgICAgICAgICAkc3BhY2VyIC8gMiAhZGVmYXVsdDtcbiRuYXZiYXItcGFkZGluZy14OiAgICAgICAgICAgICAgICAgICRzcGFjZXIgIWRlZmF1bHQ7XG5cbiRuYXZiYXItbmF2LWxpbmstcGFkZGluZy14OiAgICAgICAgIC41cmVtICFkZWZhdWx0O1xuXG4kbmF2YmFyLWJyYW5kLWZvbnQtc2l6ZTogICAgICAgICAgICAkZm9udC1zaXplLWxnICFkZWZhdWx0O1xuLy8gQ29tcHV0ZSB0aGUgbmF2YmFyLWJyYW5kIHBhZGRpbmcteSBzbyB0aGUgbmF2YmFyLWJyYW5kIHdpbGwgaGF2ZSB0aGUgc2FtZSBoZWlnaHQgYXMgbmF2YmFyLXRleHQgYW5kIG5hdi1saW5rXG4kbmF2LWxpbmstaGVpZ2h0OiAgICAgICAgICAgICAgICAgICAkZm9udC1zaXplLWJhc2UgKiAkbGluZS1oZWlnaHQtYmFzZSArICRuYXYtbGluay1wYWRkaW5nLXkgKiAyICFkZWZhdWx0O1xuJG5hdmJhci1icmFuZC1oZWlnaHQ6ICAgICAgICAgICAgICAgJG5hdmJhci1icmFuZC1mb250LXNpemUgKiAkbGluZS1oZWlnaHQtYmFzZSAhZGVmYXVsdDtcbiRuYXZiYXItYnJhbmQtcGFkZGluZy15OiAgICAgICAgICAgICgkbmF2LWxpbmstaGVpZ2h0IC0gJG5hdmJhci1icmFuZC1oZWlnaHQpIC8gMiAhZGVmYXVsdDtcblxuJG5hdmJhci10b2dnbGVyLXBhZGRpbmcteTogICAgICAgICAgLjI1cmVtICFkZWZhdWx0O1xuJG5hdmJhci10b2dnbGVyLXBhZGRpbmcteDogICAgICAgICAgLjc1cmVtICFkZWZhdWx0O1xuJG5hdmJhci10b2dnbGVyLWZvbnQtc2l6ZTogICAgICAgICAgJGZvbnQtc2l6ZS1sZyAhZGVmYXVsdDtcbiRuYXZiYXItdG9nZ2xlci1ib3JkZXItcmFkaXVzOiAgICAgICRidG4tYm9yZGVyLXJhZGl1cyAhZGVmYXVsdDtcblxuJG5hdmJhci1kYXJrLWNvbG9yOiAgICAgICAgICAgICAgICAgcmdiYSgkd2hpdGUsIC41KSAhZGVmYXVsdDtcbiRuYXZiYXItZGFyay1ob3Zlci1jb2xvcjogICAgICAgICAgIHJnYmEoJHdoaXRlLCAuNzUpICFkZWZhdWx0O1xuJG5hdmJhci1kYXJrLWFjdGl2ZS1jb2xvcjogICAgICAgICAgJHdoaXRlICFkZWZhdWx0O1xuJG5hdmJhci1kYXJrLWRpc2FibGVkLWNvbG9yOiAgICAgICAgcmdiYSgkd2hpdGUsIC4yNSkgIWRlZmF1bHQ7XG4kbmF2YmFyLWRhcmstdG9nZ2xlci1pY29uLWJnOiAgICAgICB1cmwoXCJkYXRhOmltYWdlL3N2Zyt4bWwsPHN2ZyB4bWxucz0naHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmcnIHdpZHRoPSczMCcgaGVpZ2h0PSczMCcgdmlld0JveD0nMCAwIDMwIDMwJz48cGF0aCBzdHJva2U9JyN7JG5hdmJhci1kYXJrLWNvbG9yfScgc3Ryb2tlLWxpbmVjYXA9J3JvdW5kJyBzdHJva2UtbWl0ZXJsaW1pdD0nMTAnIHN0cm9rZS13aWR0aD0nMicgZD0nTTQgN2gyMk00IDE1aDIyTTQgMjNoMjInLz48L3N2Zz5cIikgIWRlZmF1bHQ7XG4kbmF2YmFyLWRhcmstdG9nZ2xlci1ib3JkZXItY29sb3I6ICByZ2JhKCR3aGl0ZSwgLjEpICFkZWZhdWx0O1xuXG4kbmF2YmFyLWxpZ2h0LWNvbG9yOiAgICAgICAgICAgICAgICByZ2JhKCRibGFjaywgLjUpICFkZWZhdWx0O1xuJG5hdmJhci1saWdodC1ob3Zlci1jb2xvcjogICAgICAgICAgcmdiYSgkYmxhY2ssIC43KSAhZGVmYXVsdDtcbiRuYXZiYXItbGlnaHQtYWN0aXZlLWNvbG9yOiAgICAgICAgIHJnYmEoJGJsYWNrLCAuOSkgIWRlZmF1bHQ7XG4kbmF2YmFyLWxpZ2h0LWRpc2FibGVkLWNvbG9yOiAgICAgICByZ2JhKCRibGFjaywgLjMpICFkZWZhdWx0O1xuJG5hdmJhci1saWdodC10b2dnbGVyLWljb24tYmc6ICAgICAgdXJsKFwiZGF0YTppbWFnZS9zdmcreG1sLDxzdmcgeG1sbnM9J2h0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnJyB3aWR0aD0nMzAnIGhlaWdodD0nMzAnIHZpZXdCb3g9JzAgMCAzMCAzMCc+PHBhdGggc3Ryb2tlPScjeyRuYXZiYXItbGlnaHQtY29sb3J9JyBzdHJva2UtbGluZWNhcD0ncm91bmQnIHN0cm9rZS1taXRlcmxpbWl0PScxMCcgc3Ryb2tlLXdpZHRoPScyJyBkPSdNNCA3aDIyTTQgMTVoMjJNNCAyM2gyMicvPjwvc3ZnPlwiKSAhZGVmYXVsdDtcbiRuYXZiYXItbGlnaHQtdG9nZ2xlci1ib3JkZXItY29sb3I6IHJnYmEoJGJsYWNrLCAuMSkgIWRlZmF1bHQ7XG5cbiRuYXZiYXItbGlnaHQtYnJhbmQtY29sb3I6ICAgICAgICAgICAgICAgICRuYXZiYXItbGlnaHQtYWN0aXZlLWNvbG9yICFkZWZhdWx0O1xuJG5hdmJhci1saWdodC1icmFuZC1ob3Zlci1jb2xvcjogICAgICAgICAgJG5hdmJhci1saWdodC1hY3RpdmUtY29sb3IgIWRlZmF1bHQ7XG4kbmF2YmFyLWRhcmstYnJhbmQtY29sb3I6ICAgICAgICAgICAgICAgICAkbmF2YmFyLWRhcmstYWN0aXZlLWNvbG9yICFkZWZhdWx0O1xuJG5hdmJhci1kYXJrLWJyYW5kLWhvdmVyLWNvbG9yOiAgICAgICAgICAgJG5hdmJhci1kYXJrLWFjdGl2ZS1jb2xvciAhZGVmYXVsdDtcblxuXG4vLyBEcm9wZG93bnNcbi8vXG4vLyBEcm9wZG93biBtZW51IGNvbnRhaW5lciBhbmQgY29udGVudHMuXG5cbiRkcm9wZG93bi1taW4td2lkdGg6ICAgICAgICAgICAgICAgIDEwcmVtICFkZWZhdWx0O1xuJGRyb3Bkb3duLXBhZGRpbmcteTogICAgICAgICAgICAgICAgLjVyZW0gIWRlZmF1bHQ7XG4kZHJvcGRvd24tc3BhY2VyOiAgICAgICAgICAgICAgICAgICAuMTI1cmVtICFkZWZhdWx0O1xuJGRyb3Bkb3duLWZvbnQtc2l6ZTogICAgICAgICAgICAgICAgJGZvbnQtc2l6ZS1iYXNlICFkZWZhdWx0O1xuJGRyb3Bkb3duLWNvbG9yOiAgICAgICAgICAgICAgICAgICAgJGJvZHktY29sb3IgIWRlZmF1bHQ7XG4kZHJvcGRvd24tYmc6ICAgICAgICAgICAgICAgICAgICAgICAkd2hpdGUgIWRlZmF1bHQ7XG4kZHJvcGRvd24tYm9yZGVyLWNvbG9yOiAgICAgICAgICAgICByZ2JhKCRibGFjaywgLjE1KSAhZGVmYXVsdDtcbiRkcm9wZG93bi1ib3JkZXItcmFkaXVzOiAgICAgICAgICAgICRib3JkZXItcmFkaXVzICFkZWZhdWx0O1xuJGRyb3Bkb3duLWJvcmRlci13aWR0aDogICAgICAgICAgICAgJGJvcmRlci13aWR0aCAhZGVmYXVsdDtcbiRkcm9wZG93bi1pbm5lci1ib3JkZXItcmFkaXVzOiAgICAgIHN1YnRyYWN0KCRkcm9wZG93bi1ib3JkZXItcmFkaXVzLCAkZHJvcGRvd24tYm9yZGVyLXdpZHRoKSAhZGVmYXVsdDtcbiRkcm9wZG93bi1kaXZpZGVyLWJnOiAgICAgICAgICAgICAgICRncmF5LTIwMCAhZGVmYXVsdDtcbiRkcm9wZG93bi1kaXZpZGVyLW1hcmdpbi15OiAgICAgICAgICRuYXYtZGl2aWRlci1tYXJnaW4teSAhZGVmYXVsdDtcbiRkcm9wZG93bi1ib3gtc2hhZG93OiAgICAgICAgICAgICAgIDAgLjVyZW0gMXJlbSByZ2JhKCRibGFjaywgLjE3NSkgIWRlZmF1bHQ7XG5cbiRkcm9wZG93bi1saW5rLWNvbG9yOiAgICAgICAgICAgICAgICRncmF5LTkwMCAhZGVmYXVsdDtcbiRkcm9wZG93bi1saW5rLWhvdmVyLWNvbG9yOiAgICAgICAgIGRhcmtlbigkZ3JheS05MDAsIDUlKSAhZGVmYXVsdDtcbiRkcm9wZG93bi1saW5rLWhvdmVyLWJnOiAgICAgICAgICAgICRncmF5LTEwMCAhZGVmYXVsdDtcblxuJGRyb3Bkb3duLWxpbmstYWN0aXZlLWNvbG9yOiAgICAgICAgJGNvbXBvbmVudC1hY3RpdmUtY29sb3IgIWRlZmF1bHQ7XG4kZHJvcGRvd24tbGluay1hY3RpdmUtYmc6ICAgICAgICAgICAkY29tcG9uZW50LWFjdGl2ZS1iZyAhZGVmYXVsdDtcblxuJGRyb3Bkb3duLWxpbmstZGlzYWJsZWQtY29sb3I6ICAgICAgJGdyYXktNjAwICFkZWZhdWx0O1xuXG4kZHJvcGRvd24taXRlbS1wYWRkaW5nLXk6ICAgICAgICAgICAuMjVyZW0gIWRlZmF1bHQ7XG4kZHJvcGRvd24taXRlbS1wYWRkaW5nLXg6ICAgICAgICAgICAxLjVyZW0gIWRlZmF1bHQ7XG5cbiRkcm9wZG93bi1oZWFkZXItY29sb3I6ICAgICAgICAgICAgICRncmF5LTYwMCAhZGVmYXVsdDtcbiRkcm9wZG93bi1oZWFkZXItcGFkZGluZzogICAgICAgICAgICRkcm9wZG93bi1wYWRkaW5nLXkgJGRyb3Bkb3duLWl0ZW0tcGFkZGluZy14ICFkZWZhdWx0O1xuXG5cbi8vIFBhZ2luYXRpb25cblxuJHBhZ2luYXRpb24tcGFkZGluZy15OiAgICAgICAgICAgICAgLjVyZW0gIWRlZmF1bHQ7XG4kcGFnaW5hdGlvbi1wYWRkaW5nLXg6ICAgICAgICAgICAgICAuNzVyZW0gIWRlZmF1bHQ7XG4kcGFnaW5hdGlvbi1wYWRkaW5nLXktc206ICAgICAgICAgICAuMjVyZW0gIWRlZmF1bHQ7XG4kcGFnaW5hdGlvbi1wYWRkaW5nLXgtc206ICAgICAgICAgICAuNXJlbSAhZGVmYXVsdDtcbiRwYWdpbmF0aW9uLXBhZGRpbmcteS1sZzogICAgICAgICAgIC43NXJlbSAhZGVmYXVsdDtcbiRwYWdpbmF0aW9uLXBhZGRpbmcteC1sZzogICAgICAgICAgIDEuNXJlbSAhZGVmYXVsdDtcbiRwYWdpbmF0aW9uLWxpbmUtaGVpZ2h0OiAgICAgICAgICAgIDEuMjUgIWRlZmF1bHQ7XG5cbiRwYWdpbmF0aW9uLWNvbG9yOiAgICAgICAgICAgICAgICAgICRsaW5rLWNvbG9yICFkZWZhdWx0O1xuJHBhZ2luYXRpb24tYmc6ICAgICAgICAgICAgICAgICAgICAgJHdoaXRlICFkZWZhdWx0O1xuJHBhZ2luYXRpb24tYm9yZGVyLXdpZHRoOiAgICAgICAgICAgJGJvcmRlci13aWR0aCAhZGVmYXVsdDtcbiRwYWdpbmF0aW9uLWJvcmRlci1jb2xvcjogICAgICAgICAgICRncmF5LTMwMCAhZGVmYXVsdDtcblxuJHBhZ2luYXRpb24tZm9jdXMtYm94LXNoYWRvdzogICAgICAgJGlucHV0LWJ0bi1mb2N1cy1ib3gtc2hhZG93ICFkZWZhdWx0O1xuJHBhZ2luYXRpb24tZm9jdXMtb3V0bGluZTogICAgICAgICAgMCAhZGVmYXVsdDtcblxuJHBhZ2luYXRpb24taG92ZXItY29sb3I6ICAgICAgICAgICAgJGxpbmstaG92ZXItY29sb3IgIWRlZmF1bHQ7XG4kcGFnaW5hdGlvbi1ob3Zlci1iZzogICAgICAgICAgICAgICAkZ3JheS0yMDAgIWRlZmF1bHQ7XG4kcGFnaW5hdGlvbi1ob3Zlci1ib3JkZXItY29sb3I6ICAgICAkZ3JheS0zMDAgIWRlZmF1bHQ7XG5cbiRwYWdpbmF0aW9uLWFjdGl2ZS1jb2xvcjogICAgICAgICAgICRjb21wb25lbnQtYWN0aXZlLWNvbG9yICFkZWZhdWx0O1xuJHBhZ2luYXRpb24tYWN0aXZlLWJnOiAgICAgICAgICAgICAgJGNvbXBvbmVudC1hY3RpdmUtYmcgIWRlZmF1bHQ7XG4kcGFnaW5hdGlvbi1hY3RpdmUtYm9yZGVyLWNvbG9yOiAgICAkcGFnaW5hdGlvbi1hY3RpdmUtYmcgIWRlZmF1bHQ7XG5cbiRwYWdpbmF0aW9uLWRpc2FibGVkLWNvbG9yOiAgICAgICAgICRncmF5LTYwMCAhZGVmYXVsdDtcbiRwYWdpbmF0aW9uLWRpc2FibGVkLWJnOiAgICAgICAgICAgICR3aGl0ZSAhZGVmYXVsdDtcbiRwYWdpbmF0aW9uLWRpc2FibGVkLWJvcmRlci1jb2xvcjogICRncmF5LTMwMCAhZGVmYXVsdDtcblxuXG4vLyBKdW1ib3Ryb25cblxuJGp1bWJvdHJvbi1wYWRkaW5nOiAgICAgICAgICAgICAgICAgMnJlbSAhZGVmYXVsdDtcbiRqdW1ib3Ryb24tY29sb3I6ICAgICAgICAgICAgICAgICAgIG51bGwgIWRlZmF1bHQ7XG4kanVtYm90cm9uLWJnOiAgICAgICAgICAgICAgICAgICAgICAkZ3JheS0yMDAgIWRlZmF1bHQ7XG5cblxuLy8gQ2FyZHNcblxuJGNhcmQtc3BhY2VyLXk6ICAgICAgICAgICAgICAgICAgICAgLjc1cmVtICFkZWZhdWx0O1xuJGNhcmQtc3BhY2VyLXg6ICAgICAgICAgICAgICAgICAgICAgMS4yNXJlbSAhZGVmYXVsdDtcbiRjYXJkLWJvcmRlci13aWR0aDogICAgICAgICAgICAgICAgICRib3JkZXItd2lkdGggIWRlZmF1bHQ7XG4kY2FyZC1ib3JkZXItcmFkaXVzOiAgICAgICAgICAgICAgICAkYm9yZGVyLXJhZGl1cyAhZGVmYXVsdDtcbiRjYXJkLWJvcmRlci1jb2xvcjogICAgICAgICAgICAgICAgIHJnYmEoJGJsYWNrLCAuMTI1KSAhZGVmYXVsdDtcbiRjYXJkLWlubmVyLWJvcmRlci1yYWRpdXM6ICAgICAgICAgIHN1YnRyYWN0KCRjYXJkLWJvcmRlci1yYWRpdXMsICRjYXJkLWJvcmRlci13aWR0aCkgIWRlZmF1bHQ7XG4kY2FyZC1jYXAtYmc6ICAgICAgICAgICAgICAgICAgICAgICByZ2JhKCRibGFjaywgLjAzKSAhZGVmYXVsdDtcbiRjYXJkLWNhcC1jb2xvcjogICAgICAgICAgICAgICAgICAgIG51bGwgIWRlZmF1bHQ7XG4kY2FyZC1oZWlnaHQ6ICAgICAgICAgICAgICAgICAgICAgICBudWxsICFkZWZhdWx0O1xuJGNhcmQtY29sb3I6ICAgICAgICAgICAgICAgICAgICAgICAgbnVsbCAhZGVmYXVsdDtcbiRjYXJkLWJnOiAgICAgICAgICAgICAgICAgICAgICAgICAgICR3aGl0ZSAhZGVmYXVsdDtcblxuJGNhcmQtaW1nLW92ZXJsYXktcGFkZGluZzogICAgICAgICAgMS4yNXJlbSAhZGVmYXVsdDtcblxuJGNhcmQtZ3JvdXAtbWFyZ2luOiAgICAgICAgICAgICAgICAgJGdyaWQtZ3V0dGVyLXdpZHRoIC8gMiAhZGVmYXVsdDtcbiRjYXJkLWRlY2stbWFyZ2luOiAgICAgICAgICAgICAgICAgICRjYXJkLWdyb3VwLW1hcmdpbiAhZGVmYXVsdDtcblxuJGNhcmQtY29sdW1ucy1jb3VudDogICAgICAgICAgICAgICAgMyAhZGVmYXVsdDtcbiRjYXJkLWNvbHVtbnMtZ2FwOiAgICAgICAgICAgICAgICAgIDEuMjVyZW0gIWRlZmF1bHQ7XG4kY2FyZC1jb2x1bW5zLW1hcmdpbjogICAgICAgICAgICAgICAkY2FyZC1zcGFjZXIteSAhZGVmYXVsdDtcblxuXG4vLyBUb29sdGlwc1xuXG4kdG9vbHRpcC1mb250LXNpemU6ICAgICAgICAgICAgICAgICAkZm9udC1zaXplLXNtICFkZWZhdWx0O1xuJHRvb2x0aXAtbWF4LXdpZHRoOiAgICAgICAgICAgICAgICAgMjAwcHggIWRlZmF1bHQ7XG4kdG9vbHRpcC1jb2xvcjogICAgICAgICAgICAgICAgICAgICAkd2hpdGUgIWRlZmF1bHQ7XG4kdG9vbHRpcC1iZzogICAgICAgICAgICAgICAgICAgICAgICAkYmxhY2sgIWRlZmF1bHQ7XG4kdG9vbHRpcC1ib3JkZXItcmFkaXVzOiAgICAgICAgICAgICAkYm9yZGVyLXJhZGl1cyAhZGVmYXVsdDtcbiR0b29sdGlwLW9wYWNpdHk6ICAgICAgICAgICAgICAgICAgIC45ICFkZWZhdWx0O1xuJHRvb2x0aXAtcGFkZGluZy15OiAgICAgICAgICAgICAgICAgLjI1cmVtICFkZWZhdWx0O1xuJHRvb2x0aXAtcGFkZGluZy14OiAgICAgICAgICAgICAgICAgLjVyZW0gIWRlZmF1bHQ7XG4kdG9vbHRpcC1tYXJnaW46ICAgICAgICAgICAgICAgICAgICAwICFkZWZhdWx0O1xuXG4kdG9vbHRpcC1hcnJvdy13aWR0aDogICAgICAgICAgICAgICAuOHJlbSAhZGVmYXVsdDtcbiR0b29sdGlwLWFycm93LWhlaWdodDogICAgICAgICAgICAgIC40cmVtICFkZWZhdWx0O1xuJHRvb2x0aXAtYXJyb3ctY29sb3I6ICAgICAgICAgICAgICAgJHRvb2x0aXAtYmcgIWRlZmF1bHQ7XG5cbi8vIEZvcm0gdG9vbHRpcHMgbXVzdCBjb21lIGFmdGVyIHJlZ3VsYXIgdG9vbHRpcHNcbiRmb3JtLWZlZWRiYWNrLXRvb2x0aXAtcGFkZGluZy15OiAgICAgJHRvb2x0aXAtcGFkZGluZy15ICFkZWZhdWx0O1xuJGZvcm0tZmVlZGJhY2stdG9vbHRpcC1wYWRkaW5nLXg6ICAgICAkdG9vbHRpcC1wYWRkaW5nLXggIWRlZmF1bHQ7XG4kZm9ybS1mZWVkYmFjay10b29sdGlwLWZvbnQtc2l6ZTogICAgICR0b29sdGlwLWZvbnQtc2l6ZSAhZGVmYXVsdDtcbiRmb3JtLWZlZWRiYWNrLXRvb2x0aXAtbGluZS1oZWlnaHQ6ICAgJGxpbmUtaGVpZ2h0LWJhc2UgIWRlZmF1bHQ7XG4kZm9ybS1mZWVkYmFjay10b29sdGlwLW9wYWNpdHk6ICAgICAgICR0b29sdGlwLW9wYWNpdHkgIWRlZmF1bHQ7XG4kZm9ybS1mZWVkYmFjay10b29sdGlwLWJvcmRlci1yYWRpdXM6ICR0b29sdGlwLWJvcmRlci1yYWRpdXMgIWRlZmF1bHQ7XG5cblxuLy8gUG9wb3ZlcnNcblxuJHBvcG92ZXItZm9udC1zaXplOiAgICAgICAgICAgICAgICAgJGZvbnQtc2l6ZS1zbSAhZGVmYXVsdDtcbiRwb3BvdmVyLWJnOiAgICAgICAgICAgICAgICAgICAgICAgICR3aGl0ZSAhZGVmYXVsdDtcbiRwb3BvdmVyLW1heC13aWR0aDogICAgICAgICAgICAgICAgIDI3NnB4ICFkZWZhdWx0O1xuJHBvcG92ZXItYm9yZGVyLXdpZHRoOiAgICAgICAgICAgICAgJGJvcmRlci13aWR0aCAhZGVmYXVsdDtcbiRwb3BvdmVyLWJvcmRlci1jb2xvcjogICAgICAgICAgICAgIHJnYmEoJGJsYWNrLCAuMikgIWRlZmF1bHQ7XG4kcG9wb3Zlci1ib3JkZXItcmFkaXVzOiAgICAgICAgICAgICAkYm9yZGVyLXJhZGl1cy1sZyAhZGVmYXVsdDtcbiRwb3BvdmVyLWlubmVyLWJvcmRlci1yYWRpdXM6ICAgICAgIHN1YnRyYWN0KCRwb3BvdmVyLWJvcmRlci1yYWRpdXMsICRwb3BvdmVyLWJvcmRlci13aWR0aCkgIWRlZmF1bHQ7XG4kcG9wb3Zlci1ib3gtc2hhZG93OiAgICAgICAgICAgICAgICAwIC4yNXJlbSAuNXJlbSByZ2JhKCRibGFjaywgLjIpICFkZWZhdWx0O1xuXG4kcG9wb3Zlci1oZWFkZXItYmc6ICAgICAgICAgICAgICAgICBkYXJrZW4oJHBvcG92ZXItYmcsIDMlKSAhZGVmYXVsdDtcbiRwb3BvdmVyLWhlYWRlci1jb2xvcjogICAgICAgICAgICAgICRoZWFkaW5ncy1jb2xvciAhZGVmYXVsdDtcbiRwb3BvdmVyLWhlYWRlci1wYWRkaW5nLXk6ICAgICAgICAgIC41cmVtICFkZWZhdWx0O1xuJHBvcG92ZXItaGVhZGVyLXBhZGRpbmcteDogICAgICAgICAgLjc1cmVtICFkZWZhdWx0O1xuXG4kcG9wb3Zlci1ib2R5LWNvbG9yOiAgICAgICAgICAgICAgICAkYm9keS1jb2xvciAhZGVmYXVsdDtcbiRwb3BvdmVyLWJvZHktcGFkZGluZy15OiAgICAgICAgICAgICRwb3BvdmVyLWhlYWRlci1wYWRkaW5nLXkgIWRlZmF1bHQ7XG4kcG9wb3Zlci1ib2R5LXBhZGRpbmcteDogICAgICAgICAgICAkcG9wb3Zlci1oZWFkZXItcGFkZGluZy14ICFkZWZhdWx0O1xuXG4kcG9wb3Zlci1hcnJvdy13aWR0aDogICAgICAgICAgICAgICAxcmVtICFkZWZhdWx0O1xuJHBvcG92ZXItYXJyb3ctaGVpZ2h0OiAgICAgICAgICAgICAgLjVyZW0gIWRlZmF1bHQ7XG4kcG9wb3Zlci1hcnJvdy1jb2xvcjogICAgICAgICAgICAgICAkcG9wb3Zlci1iZyAhZGVmYXVsdDtcblxuJHBvcG92ZXItYXJyb3ctb3V0ZXItY29sb3I6ICAgICAgICAgZmFkZS1pbigkcG9wb3Zlci1ib3JkZXItY29sb3IsIC4wNSkgIWRlZmF1bHQ7XG5cblxuLy8gVG9hc3RzXG5cbiR0b2FzdC1tYXgtd2lkdGg6ICAgICAgICAgICAgICAgICAgIDM1MHB4ICFkZWZhdWx0O1xuJHRvYXN0LXBhZGRpbmcteDogICAgICAgICAgICAgICAgICAgLjc1cmVtICFkZWZhdWx0O1xuJHRvYXN0LXBhZGRpbmcteTogICAgICAgICAgICAgICAgICAgLjI1cmVtICFkZWZhdWx0O1xuJHRvYXN0LWZvbnQtc2l6ZTogICAgICAgICAgICAgICAgICAgLjg3NXJlbSAhZGVmYXVsdDtcbiR0b2FzdC1jb2xvcjogICAgICAgICAgICAgICAgICAgICAgIG51bGwgIWRlZmF1bHQ7XG4kdG9hc3QtYmFja2dyb3VuZC1jb2xvcjogICAgICAgICAgICByZ2JhKCR3aGl0ZSwgLjg1KSAhZGVmYXVsdDtcbiR0b2FzdC1ib3JkZXItd2lkdGg6ICAgICAgICAgICAgICAgIDFweCAhZGVmYXVsdDtcbiR0b2FzdC1ib3JkZXItY29sb3I6ICAgICAgICAgICAgICAgIHJnYmEoMCwgMCwgMCwgLjEpICFkZWZhdWx0O1xuJHRvYXN0LWJvcmRlci1yYWRpdXM6ICAgICAgICAgICAgICAgLjI1cmVtICFkZWZhdWx0O1xuJHRvYXN0LWJveC1zaGFkb3c6ICAgICAgICAgICAgICAgICAgMCAuMjVyZW0gLjc1cmVtIHJnYmEoJGJsYWNrLCAuMSkgIWRlZmF1bHQ7XG5cbiR0b2FzdC1oZWFkZXItY29sb3I6ICAgICAgICAgICAgICAgICRncmF5LTYwMCAhZGVmYXVsdDtcbiR0b2FzdC1oZWFkZXItYmFja2dyb3VuZC1jb2xvcjogICAgIHJnYmEoJHdoaXRlLCAuODUpICFkZWZhdWx0O1xuJHRvYXN0LWhlYWRlci1ib3JkZXItY29sb3I6ICAgICAgICAgcmdiYSgwLCAwLCAwLCAuMDUpICFkZWZhdWx0O1xuXG5cbi8vIEJhZGdlc1xuXG4kYmFkZ2UtZm9udC1zaXplOiAgICAgICAgICAgICAgICAgICA3NSUgIWRlZmF1bHQ7XG4kYmFkZ2UtZm9udC13ZWlnaHQ6ICAgICAgICAgICAgICAgICAkZm9udC13ZWlnaHQtYm9sZCAhZGVmYXVsdDtcbiRiYWRnZS1wYWRkaW5nLXk6ICAgICAgICAgICAgICAgICAgIC4yNWVtICFkZWZhdWx0O1xuJGJhZGdlLXBhZGRpbmcteDogICAgICAgICAgICAgICAgICAgLjRlbSAhZGVmYXVsdDtcbiRiYWRnZS1ib3JkZXItcmFkaXVzOiAgICAgICAgICAgICAgICRib3JkZXItcmFkaXVzICFkZWZhdWx0O1xuXG4kYmFkZ2UtdHJhbnNpdGlvbjogICAgICAgICAgICAgICAgICAkYnRuLXRyYW5zaXRpb24gIWRlZmF1bHQ7XG4kYmFkZ2UtZm9jdXMtd2lkdGg6ICAgICAgICAgICAgICAgICAkaW5wdXQtYnRuLWZvY3VzLXdpZHRoICFkZWZhdWx0O1xuXG4kYmFkZ2UtcGlsbC1wYWRkaW5nLXg6ICAgICAgICAgICAgICAuNmVtICFkZWZhdWx0O1xuLy8gVXNlIGEgaGlnaGVyIHRoYW4gbm9ybWFsIHZhbHVlIHRvIGVuc3VyZSBjb21wbGV0ZWx5IHJvdW5kZWQgZWRnZXMgd2hlblxuLy8gY3VzdG9taXppbmcgcGFkZGluZyBvciBmb250LXNpemUgb24gbGFiZWxzLlxuJGJhZGdlLXBpbGwtYm9yZGVyLXJhZGl1czogICAgICAgICAgMTByZW0gIWRlZmF1bHQ7XG5cblxuLy8gTW9kYWxzXG5cbi8vIFBhZGRpbmcgYXBwbGllZCB0byB0aGUgbW9kYWwgYm9keVxuJG1vZGFsLWlubmVyLXBhZGRpbmc6ICAgICAgICAgICAgICAgMXJlbSAhZGVmYXVsdDtcblxuLy8gTWFyZ2luIGJldHdlZW4gZWxlbWVudHMgaW4gZm9vdGVyLCBtdXN0IGJlIGxvd2VyIHRoYW4gb3IgZXF1YWwgdG8gMiAqICRtb2RhbC1pbm5lci1wYWRkaW5nXG4kbW9kYWwtZm9vdGVyLW1hcmdpbi1iZXR3ZWVuOiAgICAgICAuNXJlbSAhZGVmYXVsdDtcblxuJG1vZGFsLWRpYWxvZy1tYXJnaW46ICAgICAgICAgICAgICAgLjVyZW0gIWRlZmF1bHQ7XG4kbW9kYWwtZGlhbG9nLW1hcmdpbi15LXNtLXVwOiAgICAgICAxLjc1cmVtICFkZWZhdWx0O1xuXG4kbW9kYWwtdGl0bGUtbGluZS1oZWlnaHQ6ICAgICAgICAgICAkbGluZS1oZWlnaHQtYmFzZSAhZGVmYXVsdDtcblxuJG1vZGFsLWNvbnRlbnQtY29sb3I6ICAgICAgICAgICAgICAgbnVsbCAhZGVmYXVsdDtcbiRtb2RhbC1jb250ZW50LWJnOiAgICAgICAgICAgICAgICAgICR3aGl0ZSAhZGVmYXVsdDtcbiRtb2RhbC1jb250ZW50LWJvcmRlci1jb2xvcjogICAgICAgIHJnYmEoJGJsYWNrLCAuMikgIWRlZmF1bHQ7XG4kbW9kYWwtY29udGVudC1ib3JkZXItd2lkdGg6ICAgICAgICAkYm9yZGVyLXdpZHRoICFkZWZhdWx0O1xuJG1vZGFsLWNvbnRlbnQtYm9yZGVyLXJhZGl1czogICAgICAgJGJvcmRlci1yYWRpdXMtbGcgIWRlZmF1bHQ7XG4kbW9kYWwtY29udGVudC1pbm5lci1ib3JkZXItcmFkaXVzOiBzdWJ0cmFjdCgkbW9kYWwtY29udGVudC1ib3JkZXItcmFkaXVzLCAkbW9kYWwtY29udGVudC1ib3JkZXItd2lkdGgpICFkZWZhdWx0O1xuJG1vZGFsLWNvbnRlbnQtYm94LXNoYWRvdy14czogICAgICAgMCAuMjVyZW0gLjVyZW0gcmdiYSgkYmxhY2ssIC41KSAhZGVmYXVsdDtcbiRtb2RhbC1jb250ZW50LWJveC1zaGFkb3ctc20tdXA6ICAgIDAgLjVyZW0gMXJlbSByZ2JhKCRibGFjaywgLjUpICFkZWZhdWx0O1xuXG4kbW9kYWwtYmFja2Ryb3AtYmc6ICAgICAgICAgICAgICAgICAkYmxhY2sgIWRlZmF1bHQ7XG4kbW9kYWwtYmFja2Ryb3Atb3BhY2l0eTogICAgICAgICAgICAuNSAhZGVmYXVsdDtcbiRtb2RhbC1oZWFkZXItYm9yZGVyLWNvbG9yOiAgICAgICAgICRib3JkZXItY29sb3IgIWRlZmF1bHQ7XG4kbW9kYWwtZm9vdGVyLWJvcmRlci1jb2xvcjogICAgICAgICAkbW9kYWwtaGVhZGVyLWJvcmRlci1jb2xvciAhZGVmYXVsdDtcbiRtb2RhbC1oZWFkZXItYm9yZGVyLXdpZHRoOiAgICAgICAgICRtb2RhbC1jb250ZW50LWJvcmRlci13aWR0aCAhZGVmYXVsdDtcbiRtb2RhbC1mb290ZXItYm9yZGVyLXdpZHRoOiAgICAgICAgICRtb2RhbC1oZWFkZXItYm9yZGVyLXdpZHRoICFkZWZhdWx0O1xuJG1vZGFsLWhlYWRlci1wYWRkaW5nLXk6ICAgICAgICAgICAgMXJlbSAhZGVmYXVsdDtcbiRtb2RhbC1oZWFkZXItcGFkZGluZy14OiAgICAgICAgICAgIDFyZW0gIWRlZmF1bHQ7XG4kbW9kYWwtaGVhZGVyLXBhZGRpbmc6ICAgICAgICAgICAgICAkbW9kYWwtaGVhZGVyLXBhZGRpbmcteSAkbW9kYWwtaGVhZGVyLXBhZGRpbmcteCAhZGVmYXVsdDsgLy8gS2VlcCB0aGlzIGZvciBiYWNrd2FyZHMgY29tcGF0aWJpbGl0eVxuXG4kbW9kYWwteGw6ICAgICAgICAgICAgICAgICAgICAgICAgICAxMTQwcHggIWRlZmF1bHQ7XG4kbW9kYWwtbGc6ICAgICAgICAgICAgICAgICAgICAgICAgICA4MDBweCAhZGVmYXVsdDtcbiRtb2RhbC1tZDogICAgICAgICAgICAgICAgICAgICAgICAgIDUwMHB4ICFkZWZhdWx0O1xuJG1vZGFsLXNtOiAgICAgICAgICAgICAgICAgICAgICAgICAgMzAwcHggIWRlZmF1bHQ7XG5cbiRtb2RhbC1mYWRlLXRyYW5zZm9ybTogICAgICAgICAgICAgIHRyYW5zbGF0ZSgwLCAtNTBweCkgIWRlZmF1bHQ7XG4kbW9kYWwtc2hvdy10cmFuc2Zvcm06ICAgICAgICAgICAgICBub25lICFkZWZhdWx0O1xuJG1vZGFsLXRyYW5zaXRpb246ICAgICAgICAgICAgICAgICAgdHJhbnNmb3JtIC4zcyBlYXNlLW91dCAhZGVmYXVsdDtcbiRtb2RhbC1zY2FsZS10cmFuc2Zvcm06ICAgICAgICAgICAgIHNjYWxlKDEuMDIpICFkZWZhdWx0O1xuXG5cbi8vIEFsZXJ0c1xuLy9cbi8vIERlZmluZSBhbGVydCBjb2xvcnMsIGJvcmRlciByYWRpdXMsIGFuZCBwYWRkaW5nLlxuXG4kYWxlcnQtcGFkZGluZy15OiAgICAgICAgICAgICAgICAgICAuNzVyZW0gIWRlZmF1bHQ7XG4kYWxlcnQtcGFkZGluZy14OiAgICAgICAgICAgICAgICAgICAxLjI1cmVtICFkZWZhdWx0O1xuJGFsZXJ0LW1hcmdpbi1ib3R0b206ICAgICAgICAgICAgICAgMXJlbSAhZGVmYXVsdDtcbiRhbGVydC1ib3JkZXItcmFkaXVzOiAgICAgICAgICAgICAgICRib3JkZXItcmFkaXVzICFkZWZhdWx0O1xuJGFsZXJ0LWxpbmstZm9udC13ZWlnaHQ6ICAgICAgICAgICAgJGZvbnQtd2VpZ2h0LWJvbGQgIWRlZmF1bHQ7XG4kYWxlcnQtYm9yZGVyLXdpZHRoOiAgICAgICAgICAgICAgICAkYm9yZGVyLXdpZHRoICFkZWZhdWx0O1xuXG4kYWxlcnQtYmctbGV2ZWw6ICAgICAgICAgICAgICAgICAgICAtMTAgIWRlZmF1bHQ7XG4kYWxlcnQtYm9yZGVyLWxldmVsOiAgICAgICAgICAgICAgICAtOSAhZGVmYXVsdDtcbiRhbGVydC1jb2xvci1sZXZlbDogICAgICAgICAgICAgICAgIDYgIWRlZmF1bHQ7XG5cblxuLy8gUHJvZ3Jlc3MgYmFyc1xuXG4kcHJvZ3Jlc3MtaGVpZ2h0OiAgICAgICAgICAgICAgICAgICAxcmVtICFkZWZhdWx0O1xuJHByb2dyZXNzLWZvbnQtc2l6ZTogICAgICAgICAgICAgICAgJGZvbnQtc2l6ZS1iYXNlICogLjc1ICFkZWZhdWx0O1xuJHByb2dyZXNzLWJnOiAgICAgICAgICAgICAgICAgICAgICAgJGdyYXktMjAwICFkZWZhdWx0O1xuJHByb2dyZXNzLWJvcmRlci1yYWRpdXM6ICAgICAgICAgICAgJGJvcmRlci1yYWRpdXMgIWRlZmF1bHQ7XG4kcHJvZ3Jlc3MtYm94LXNoYWRvdzogICAgICAgICAgICAgICBpbnNldCAwIC4xcmVtIC4xcmVtIHJnYmEoJGJsYWNrLCAuMSkgIWRlZmF1bHQ7XG4kcHJvZ3Jlc3MtYmFyLWNvbG9yOiAgICAgICAgICAgICAgICAkd2hpdGUgIWRlZmF1bHQ7XG4kcHJvZ3Jlc3MtYmFyLWJnOiAgICAgICAgICAgICAgICAgICB0aGVtZS1jb2xvcihcInByaW1hcnlcIikgIWRlZmF1bHQ7XG4kcHJvZ3Jlc3MtYmFyLWFuaW1hdGlvbi10aW1pbmc6ICAgICAxcyBsaW5lYXIgaW5maW5pdGUgIWRlZmF1bHQ7XG4kcHJvZ3Jlc3MtYmFyLXRyYW5zaXRpb246ICAgICAgICAgICB3aWR0aCAuNnMgZWFzZSAhZGVmYXVsdDtcblxuXG4vLyBMaXN0IGdyb3VwXG5cbiRsaXN0LWdyb3VwLWNvbG9yOiAgICAgICAgICAgICAgICAgIG51bGwgIWRlZmF1bHQ7XG4kbGlzdC1ncm91cC1iZzogICAgICAgICAgICAgICAgICAgICAkd2hpdGUgIWRlZmF1bHQ7XG4kbGlzdC1ncm91cC1ib3JkZXItY29sb3I6ICAgICAgICAgICByZ2JhKCRibGFjaywgLjEyNSkgIWRlZmF1bHQ7XG4kbGlzdC1ncm91cC1ib3JkZXItd2lkdGg6ICAgICAgICAgICAkYm9yZGVyLXdpZHRoICFkZWZhdWx0O1xuJGxpc3QtZ3JvdXAtYm9yZGVyLXJhZGl1czogICAgICAgICAgJGJvcmRlci1yYWRpdXMgIWRlZmF1bHQ7XG5cbiRsaXN0LWdyb3VwLWl0ZW0tcGFkZGluZy15OiAgICAgICAgIC43NXJlbSAhZGVmYXVsdDtcbiRsaXN0LWdyb3VwLWl0ZW0tcGFkZGluZy14OiAgICAgICAgIDEuMjVyZW0gIWRlZmF1bHQ7XG5cbiRsaXN0LWdyb3VwLWhvdmVyLWJnOiAgICAgICAgICAgICAgICRncmF5LTEwMCAhZGVmYXVsdDtcbiRsaXN0LWdyb3VwLWFjdGl2ZS1jb2xvcjogICAgICAgICAgICRjb21wb25lbnQtYWN0aXZlLWNvbG9yICFkZWZhdWx0O1xuJGxpc3QtZ3JvdXAtYWN0aXZlLWJnOiAgICAgICAgICAgICAgJGNvbXBvbmVudC1hY3RpdmUtYmcgIWRlZmF1bHQ7XG4kbGlzdC1ncm91cC1hY3RpdmUtYm9yZGVyLWNvbG9yOiAgICAkbGlzdC1ncm91cC1hY3RpdmUtYmcgIWRlZmF1bHQ7XG5cbiRsaXN0LWdyb3VwLWRpc2FibGVkLWNvbG9yOiAgICAgICAgICRncmF5LTYwMCAhZGVmYXVsdDtcbiRsaXN0LWdyb3VwLWRpc2FibGVkLWJnOiAgICAgICAgICAgICRsaXN0LWdyb3VwLWJnICFkZWZhdWx0O1xuXG4kbGlzdC1ncm91cC1hY3Rpb24tY29sb3I6ICAgICAgICAgICAkZ3JheS03MDAgIWRlZmF1bHQ7XG4kbGlzdC1ncm91cC1hY3Rpb24taG92ZXItY29sb3I6ICAgICAkbGlzdC1ncm91cC1hY3Rpb24tY29sb3IgIWRlZmF1bHQ7XG5cbiRsaXN0LWdyb3VwLWFjdGlvbi1hY3RpdmUtY29sb3I6ICAgICRib2R5LWNvbG9yICFkZWZhdWx0O1xuJGxpc3QtZ3JvdXAtYWN0aW9uLWFjdGl2ZS1iZzogICAgICAgJGdyYXktMjAwICFkZWZhdWx0O1xuXG5cbi8vIEltYWdlIHRodW1ibmFpbHNcblxuJHRodW1ibmFpbC1wYWRkaW5nOiAgICAgICAgICAgICAgICAgLjI1cmVtICFkZWZhdWx0O1xuJHRodW1ibmFpbC1iZzogICAgICAgICAgICAgICAgICAgICAgJGJvZHktYmcgIWRlZmF1bHQ7XG4kdGh1bWJuYWlsLWJvcmRlci13aWR0aDogICAgICAgICAgICAkYm9yZGVyLXdpZHRoICFkZWZhdWx0O1xuJHRodW1ibmFpbC1ib3JkZXItY29sb3I6ICAgICAgICAgICAgJGdyYXktMzAwICFkZWZhdWx0O1xuJHRodW1ibmFpbC1ib3JkZXItcmFkaXVzOiAgICAgICAgICAgJGJvcmRlci1yYWRpdXMgIWRlZmF1bHQ7XG4kdGh1bWJuYWlsLWJveC1zaGFkb3c6ICAgICAgICAgICAgICAwIDFweCAycHggcmdiYSgkYmxhY2ssIC4wNzUpICFkZWZhdWx0O1xuXG5cbi8vIEZpZ3VyZXNcblxuJGZpZ3VyZS1jYXB0aW9uLWZvbnQtc2l6ZTogICAgICAgICAgOTAlICFkZWZhdWx0O1xuJGZpZ3VyZS1jYXB0aW9uLWNvbG9yOiAgICAgICAgICAgICAgJGdyYXktNjAwICFkZWZhdWx0O1xuXG5cbi8vIEJyZWFkY3J1bWJzXG5cbiRicmVhZGNydW1iLWZvbnQtc2l6ZTogICAgICAgICAgICAgIG51bGwgIWRlZmF1bHQ7XG5cbiRicmVhZGNydW1iLXBhZGRpbmcteTogICAgICAgICAgICAgIC43NXJlbSAhZGVmYXVsdDtcbiRicmVhZGNydW1iLXBhZGRpbmcteDogICAgICAgICAgICAgIDFyZW0gIWRlZmF1bHQ7XG4kYnJlYWRjcnVtYi1pdGVtLXBhZGRpbmc6ICAgICAgICAgICAuNXJlbSAhZGVmYXVsdDtcblxuJGJyZWFkY3J1bWItbWFyZ2luLWJvdHRvbTogICAgICAgICAgMXJlbSAhZGVmYXVsdDtcblxuJGJyZWFkY3J1bWItYmc6ICAgICAgICAgICAgICAgICAgICAgJGdyYXktMjAwICFkZWZhdWx0O1xuJGJyZWFkY3J1bWItZGl2aWRlci1jb2xvcjogICAgICAgICAgJGdyYXktNjAwICFkZWZhdWx0O1xuJGJyZWFkY3J1bWItYWN0aXZlLWNvbG9yOiAgICAgICAgICAgJGdyYXktNjAwICFkZWZhdWx0O1xuJGJyZWFkY3J1bWItZGl2aWRlcjogICAgICAgICAgICAgICAgcXVvdGUoXCIvXCIpICFkZWZhdWx0O1xuXG4kYnJlYWRjcnVtYi1ib3JkZXItcmFkaXVzOiAgICAgICAgICAkYm9yZGVyLXJhZGl1cyAhZGVmYXVsdDtcblxuXG4vLyBDYXJvdXNlbFxuXG4kY2Fyb3VzZWwtY29udHJvbC1jb2xvcjogICAgICAgICAgICAgJHdoaXRlICFkZWZhdWx0O1xuJGNhcm91c2VsLWNvbnRyb2wtd2lkdGg6ICAgICAgICAgICAgIDE1JSAhZGVmYXVsdDtcbiRjYXJvdXNlbC1jb250cm9sLW9wYWNpdHk6ICAgICAgICAgICAuNSAhZGVmYXVsdDtcbiRjYXJvdXNlbC1jb250cm9sLWhvdmVyLW9wYWNpdHk6ICAgICAuOSAhZGVmYXVsdDtcbiRjYXJvdXNlbC1jb250cm9sLXRyYW5zaXRpb246ICAgICAgICBvcGFjaXR5IC4xNXMgZWFzZSAhZGVmYXVsdDtcblxuJGNhcm91c2VsLWluZGljYXRvci13aWR0aDogICAgICAgICAgIDMwcHggIWRlZmF1bHQ7XG4kY2Fyb3VzZWwtaW5kaWNhdG9yLWhlaWdodDogICAgICAgICAgM3B4ICFkZWZhdWx0O1xuJGNhcm91c2VsLWluZGljYXRvci1oaXQtYXJlYS1oZWlnaHQ6IDEwcHggIWRlZmF1bHQ7XG4kY2Fyb3VzZWwtaW5kaWNhdG9yLXNwYWNlcjogICAgICAgICAgM3B4ICFkZWZhdWx0O1xuJGNhcm91c2VsLWluZGljYXRvci1hY3RpdmUtYmc6ICAgICAgICR3aGl0ZSAhZGVmYXVsdDtcbiRjYXJvdXNlbC1pbmRpY2F0b3ItdHJhbnNpdGlvbjogICAgICBvcGFjaXR5IC42cyBlYXNlICFkZWZhdWx0O1xuXG4kY2Fyb3VzZWwtY2FwdGlvbi13aWR0aDogICAgICAgICAgICAgNzAlICFkZWZhdWx0O1xuJGNhcm91c2VsLWNhcHRpb24tY29sb3I6ICAgICAgICAgICAgICR3aGl0ZSAhZGVmYXVsdDtcblxuJGNhcm91c2VsLWNvbnRyb2wtaWNvbi13aWR0aDogICAgICAgIDIwcHggIWRlZmF1bHQ7XG5cbiRjYXJvdXNlbC1jb250cm9sLXByZXYtaWNvbi1iZzogICAgICB1cmwoXCJkYXRhOmltYWdlL3N2Zyt4bWwsPHN2ZyB4bWxucz0naHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmcnIGZpbGw9JyN7JGNhcm91c2VsLWNvbnRyb2wtY29sb3J9JyB3aWR0aD0nOCcgaGVpZ2h0PSc4JyB2aWV3Qm94PScwIDAgOCA4Jz48cGF0aCBkPSdNNS4yNSAwbC00IDQgNCA0IDEuNS0xLjVMNC4yNSA0bDIuNS0yLjVMNS4yNSAweicvPjwvc3ZnPlwiKSAhZGVmYXVsdDtcbiRjYXJvdXNlbC1jb250cm9sLW5leHQtaWNvbi1iZzogICAgICB1cmwoXCJkYXRhOmltYWdlL3N2Zyt4bWwsPHN2ZyB4bWxucz0naHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmcnIGZpbGw9JyN7JGNhcm91c2VsLWNvbnRyb2wtY29sb3J9JyB3aWR0aD0nOCcgaGVpZ2h0PSc4JyB2aWV3Qm94PScwIDAgOCA4Jz48cGF0aCBkPSdNMi43NSAwbC0xLjUgMS41TDMuNzUgNGwtMi41IDIuNUwyLjc1IDhsNC00LTQtNHonLz48L3N2Zz5cIikgIWRlZmF1bHQ7XG5cbiRjYXJvdXNlbC10cmFuc2l0aW9uLWR1cmF0aW9uOiAgICAgICAuNnMgIWRlZmF1bHQ7XG4kY2Fyb3VzZWwtdHJhbnNpdGlvbjogICAgICAgICAgICAgICAgdHJhbnNmb3JtICRjYXJvdXNlbC10cmFuc2l0aW9uLWR1cmF0aW9uIGVhc2UtaW4tb3V0ICFkZWZhdWx0OyAvLyBEZWZpbmUgdHJhbnNmb3JtIHRyYW5zaXRpb24gZmlyc3QgaWYgdXNpbmcgbXVsdGlwbGUgdHJhbnNpdGlvbnMgKGUuZy4sIGB0cmFuc2Zvcm0gMnMgZWFzZSwgb3BhY2l0eSAuNXMgZWFzZS1vdXRgKVxuXG5cbi8vIFNwaW5uZXJzXG5cbiRzcGlubmVyLXdpZHRoOiAgICAgICAgIDJyZW0gIWRlZmF1bHQ7XG4kc3Bpbm5lci1oZWlnaHQ6ICAgICAgICAkc3Bpbm5lci13aWR0aCAhZGVmYXVsdDtcbiRzcGlubmVyLWJvcmRlci13aWR0aDogIC4yNWVtICFkZWZhdWx0O1xuXG4kc3Bpbm5lci13aWR0aC1zbTogICAgICAgIDFyZW0gIWRlZmF1bHQ7XG4kc3Bpbm5lci1oZWlnaHQtc206ICAgICAgICRzcGlubmVyLXdpZHRoLXNtICFkZWZhdWx0O1xuJHNwaW5uZXItYm9yZGVyLXdpZHRoLXNtOiAuMmVtICFkZWZhdWx0O1xuXG5cbi8vIENsb3NlXG5cbiRjbG9zZS1mb250LXNpemU6ICAgICAgICAgICAgICAgICAgICRmb250LXNpemUtYmFzZSAqIDEuNSAhZGVmYXVsdDtcbiRjbG9zZS1mb250LXdlaWdodDogICAgICAgICAgICAgICAgICRmb250LXdlaWdodC1ib2xkICFkZWZhdWx0O1xuJGNsb3NlLWNvbG9yOiAgICAgICAgICAgICAgICAgICAgICAgJGJsYWNrICFkZWZhdWx0O1xuJGNsb3NlLXRleHQtc2hhZG93OiAgICAgICAgICAgICAgICAgMCAxcHggMCAkd2hpdGUgIWRlZmF1bHQ7XG5cblxuLy8gQ29kZVxuXG4kY29kZS1mb250LXNpemU6ICAgICAgICAgICAgICAgICAgICA4Ny41JSAhZGVmYXVsdDtcbiRjb2RlLWNvbG9yOiAgICAgICAgICAgICAgICAgICAgICAgICRwaW5rICFkZWZhdWx0O1xuXG4ka2JkLXBhZGRpbmcteTogICAgICAgICAgICAgICAgICAgICAuMnJlbSAhZGVmYXVsdDtcbiRrYmQtcGFkZGluZy14OiAgICAgICAgICAgICAgICAgICAgIC40cmVtICFkZWZhdWx0O1xuJGtiZC1mb250LXNpemU6ICAgICAgICAgICAgICAgICAgICAgJGNvZGUtZm9udC1zaXplICFkZWZhdWx0O1xuJGtiZC1jb2xvcjogICAgICAgICAgICAgICAgICAgICAgICAgJHdoaXRlICFkZWZhdWx0O1xuJGtiZC1iZzogICAgICAgICAgICAgICAgICAgICAgICAgICAgJGdyYXktOTAwICFkZWZhdWx0O1xuXG4kcHJlLWNvbG9yOiAgICAgICAgICAgICAgICAgICAgICAgICAkZ3JheS05MDAgIWRlZmF1bHQ7XG4kcHJlLXNjcm9sbGFibGUtbWF4LWhlaWdodDogICAgICAgICAzNDBweCAhZGVmYXVsdDtcblxuXG4vLyBVdGlsaXRpZXNcblxuJGRpc3BsYXlzOiBub25lLCBpbmxpbmUsIGlubGluZS1ibG9jaywgYmxvY2ssIHRhYmxlLCB0YWJsZS1yb3csIHRhYmxlLWNlbGwsIGZsZXgsIGlubGluZS1mbGV4ICFkZWZhdWx0O1xuJG92ZXJmbG93czogYXV0bywgaGlkZGVuICFkZWZhdWx0O1xuJHBvc2l0aW9uczogc3RhdGljLCByZWxhdGl2ZSwgYWJzb2x1dGUsIGZpeGVkLCBzdGlja3kgIWRlZmF1bHQ7XG4kdXNlci1zZWxlY3RzOiBhbGwsIGF1dG8sIG5vbmUgIWRlZmF1bHQ7XG5cblxuLy8gUHJpbnRpbmdcblxuJHByaW50LXBhZ2Utc2l6ZTogICAgICAgICAgICAgICAgICAgYTMgIWRlZmF1bHQ7XG4kcHJpbnQtYm9keS1taW4td2lkdGg6ICAgICAgICAgICAgICBtYXAtZ2V0KCRncmlkLWJyZWFrcG9pbnRzLCBcImxnXCIpICFkZWZhdWx0O1xuIiwiLypcbiAqIEFwcGxpY2F0aW9uIGdsb2JhbCB2YXJpYWJsZXMuXG4gKi9cbi5uYXZiYXIge1xuICBtYXJnaW4tYm90dG9tOiAxcmVtO1xufVxuXG4ubmF2LWxpbmsuZHJvcGRvd24tdG9nZ2xlIHtcbiAgY3Vyc29yOiBwb2ludGVyO1xufSJdfQ== */",
          ],
        });
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            HeaderComponent,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
                args: [
                  {
                    selector: "app-header",
                    templateUrl: "./header.component.html",
                    styleUrls: ["./header.component.scss"],
                  },
                ],
              },
            ],
            function () {
              return [];
            },
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/shell/shell.component.ts":
      /*!******************************************!*\
    !*** ./src/app/shell/shell.component.ts ***!
    \******************************************/

      /*! exports provided: ShellComponent */

      /***/
      function srcAppShellShellComponentTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "ShellComponent",
          function () {
            return ShellComponent;
          }
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/router */
          "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js"
        );

        var ShellComponent = /*#__PURE__*/ (function () {
          function ShellComponent() {
            _classCallCheck(this, ShellComponent);
          }

          _createClass(ShellComponent, [
            {
              key: "ngOnInit",
              value: function ngOnInit() {},
            },
          ]);

          return ShellComponent;
        })();

        ShellComponent.ɵfac = function ShellComponent_Factory(t) {
          return new (t || ShellComponent)();
        };

        ShellComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineComponent"
        ]({
          type: ShellComponent,
          selectors: [["app-shell"]],
          decls: 10,
          vars: 0,
          consts: [[1, "container-fluid", "p-0"]],
          template: function ShellComponent_Template(rf, ctx) {
            if (rf & 1) {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                0,
                "div",
                0
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](
                5,
                "router-outlet"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "\n");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "\n");
            }
          },
          directives: [
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterOutlet"],
          ],
          styles: [
            "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3NoZWxsL3NoZWxsLmNvbXBvbmVudC5zY3NzIn0= */",
          ],
        });
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            ShellComponent,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
                args: [
                  {
                    selector: "app-shell",
                    templateUrl: "./shell.component.html",
                    styleUrls: ["./shell.component.scss"],
                  },
                ],
              },
            ],
            function () {
              return [];
            },
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/shell/shell.module.ts":
      /*!***************************************!*\
    !*** ./src/app/shell/shell.module.ts ***!
    \***************************************/

      /*! exports provided: ShellModule */

      /***/
      function srcAppShellShellModuleTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "ShellModule", function () {
          return ShellModule;
        });
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angular/common */
          "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js"
        );
        /* harmony import */

        var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! @ngx-translate/core */
          "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js"
        );
        /* harmony import */

        var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! @angular/router */
          "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js"
        );
        /* harmony import */

        var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
          /*! @ng-bootstrap/ng-bootstrap */
          "./node_modules/@ng-bootstrap/ng-bootstrap/__ivy_ngcc__/fesm2015/ng-bootstrap.js"
        );
        /* harmony import */

        var _app_i18n__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
          /*! @app/i18n */
          "./src/app/i18n/index.ts"
        );
        /* harmony import */

        var _shell_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
          /*! ./shell.component */
          "./src/app/shell/shell.component.ts"
        );
        /* harmony import */

        var _header_header_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
          /*! ./header/header.component */
          "./src/app/shell/header/header.component.ts"
        );
        /* harmony import */

        var _sidebar_sidebar_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(
          /*! ./sidebar/sidebar.component */
          "./src/app/shell/sidebar/sidebar.component.ts"
        );
        /* harmony import */

        var ng2_charts__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(
          /*! ng2-charts */
          "./node_modules/ng2-charts/__ivy_ngcc__/fesm2015/ng2-charts.js"
        );

        var ShellModule = function ShellModule() {
          _classCallCheck(this, ShellModule);
        };

        ShellModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineNgModule"
        ]({
          type: ShellModule,
        });
        ShellModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineInjector"
        ]({
          factory: function ShellModule_Factory(t) {
            return new (t || ShellModule)();
          },
          imports: [
            [
              _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
              _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
                "TranslateModule"
              ],
              ng2_charts__WEBPACK_IMPORTED_MODULE_9__["ChartsModule"],
              _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_4__[
                "NgbModule"
              ],
              _app_i18n__WEBPACK_IMPORTED_MODULE_5__["I18nModule"],
              _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"],
            ],
          ],
        });

        (function () {
          (typeof ngJitMode === "undefined" || ngJitMode) &&
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](
              ShellModule,
              {
                declarations: [
                  _header_header_component__WEBPACK_IMPORTED_MODULE_7__[
                    "HeaderComponent"
                  ],
                  _shell_component__WEBPACK_IMPORTED_MODULE_6__[
                    "ShellComponent"
                  ],
                  _sidebar_sidebar_component__WEBPACK_IMPORTED_MODULE_8__[
                    "SidebarComponent"
                  ],
                ],
                imports: [
                  _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                  _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
                    "TranslateModule"
                  ],
                  ng2_charts__WEBPACK_IMPORTED_MODULE_9__["ChartsModule"],
                  _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_4__[
                    "NgbModule"
                  ],
                  _app_i18n__WEBPACK_IMPORTED_MODULE_5__["I18nModule"],
                  _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"],
                ],
              }
            );
        })();
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            ShellModule,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
                args: [
                  {
                    imports: [
                      _angular_common__WEBPACK_IMPORTED_MODULE_1__[
                        "CommonModule"
                      ],
                      _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__[
                        "TranslateModule"
                      ],
                      ng2_charts__WEBPACK_IMPORTED_MODULE_9__["ChartsModule"],
                      _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_4__[
                        "NgbModule"
                      ],
                      _app_i18n__WEBPACK_IMPORTED_MODULE_5__["I18nModule"],
                      _angular_router__WEBPACK_IMPORTED_MODULE_3__[
                        "RouterModule"
                      ],
                    ],
                    declarations: [
                      _header_header_component__WEBPACK_IMPORTED_MODULE_7__[
                        "HeaderComponent"
                      ],
                      _shell_component__WEBPACK_IMPORTED_MODULE_6__[
                        "ShellComponent"
                      ],
                      _sidebar_sidebar_component__WEBPACK_IMPORTED_MODULE_8__[
                        "SidebarComponent"
                      ],
                    ],
                  },
                ],
              },
            ],
            null,
            null
          );
        })();
        /***/
      },

    /***/
    "./src/app/shell/shell.service.ts":
      /*!****************************************!*\
    !*** ./src/app/shell/shell.service.ts ***!
    \****************************************/

      /*! exports provided: Shell, themeFromMapBox */

      /***/
      function srcAppShellShellServiceTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "Shell", function () {
          return Shell;
        });
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "themeFromMapBox",
          function () {
            return themeFromMapBox;
          }
        );
        /* harmony import */

        var _shell_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! ./shell.component */
          "./src/app/shell/shell.component.ts"
        );
        /**
         * Provides helper methods to create routes.
         */

        var Shell = /*#__PURE__*/ (function () {
          function Shell() {
            _classCallCheck(this, Shell);
          }

          _createClass(Shell, null, [
            {
              key: "childRoutes",

              /**
               * Creates routes using the shell component and authentication.
               * @param routes The routes to add.
               * @return The new route using shell as the base.
               */
              value: function childRoutes(routes) {
                return {
                  path: "",
                  component:
                    _shell_component__WEBPACK_IMPORTED_MODULE_0__[
                      "ShellComponent"
                    ],
                  children: routes,
                  // Reuse ShellComponent instance when navigating between child views
                  data: {
                    reuse: true,
                  },
                };
              },
            },
          ]);

          return Shell;
        })();

        var themeFromMapBox =
          "https://api.mapbox.com/styles/v1/nikoskous/ckaid0c1y0sw21ipamlvgkzqt/tiles/256/{z}/{x}/{y}@2x?access_token=pk.eyJ1Ijoibmlrb3Nrb3VzIiwiYSI6ImNrMnRjajM5NDBxZXczbXA1YmxueGdhcmMifQ.O0Fz93cltHQ10OfqGBS7FQ";
        /***/
      },

    /***/
    "./src/app/shell/sidebar/sidebar.component.ts":
      /*!****************************************************!*\
    !*** ./src/app/shell/sidebar/sidebar.component.ts ***!
    \****************************************************/

      /*! exports provided: SidebarComponent */

      /***/
      function srcAppShellSidebarSidebarComponentTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(
          __webpack_exports__,
          "SidebarComponent",
          function () {
            return SidebarComponent;
          }
        );
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _app_home_quote_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @app/home/quote.service */
          "./src/app/home/quote.service.ts"
        );
        /* harmony import */

        var lodash__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
          /*! lodash */
          "./node_modules/lodash/lodash.js"
        );
        /* harmony import */

        var lodash__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/ __webpack_require__.n(
          lodash__WEBPACK_IMPORTED_MODULE_2__
        );
        /* harmony import */

        var ng2_charts__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
          /*! ng2-charts */
          "./node_modules/ng2-charts/__ivy_ngcc__/fesm2015/ng2-charts.js"
        );

        var SidebarComponent = /*#__PURE__*/ (function () {
          function SidebarComponent(quoteService) {
            _classCallCheck(this, SidebarComponent);

            this.quoteService = quoteService;
            this.data = []; // bar chart data

            this.barChartOptions = {
              responsive: true,
              // We use these empty structures as placeholders for dynamic theming.
              scales: {
                xAxes: [{}],
                yAxes: [{}],
              },
              plugins: {
                datalabels: {
                  anchor: "end",
                  align: "end",
                },
              },
            };
            this.barChartLabels = [
              "2006",
              "2007",
              "2008",
              "2009",
              "2010",
              "2011",
              "2012",
            ];
            this.barChartType = "bar";
            this.barChartLegend = true; // barChartPlugins = [pluginDataLabels];

            this.barChartData = [
              {
                data: [65, 59, 80, 81, 56, 55, 40],
                label: "Series A",
              },
              {
                data: [28, 48, 40, 19, 86, 27, 90],
                label: "Series B",
              },
            ]; // doughnutChart Data

            this.doughnutChartLabels = [
              "Download Sales",
              "In-Store Sales",
              "Mail-Order Sales",
            ];
            this.doughnutChartData = [
              [350, 450, 100],
              [50, 150, 120],
              [250, 130, 70],
            ];
            this.doughnutChartType = "doughnut";
          }

          _createClass(SidebarComponent, [
            {
              key: "ngOnInit",
              value: function ngOnInit() {
                var _this7 = this;

                this.quoteService.getNodaSTData().then(function (res) {
                  var parsedData = JSON.parse(res);
                  _this7.data = parsedData["data"];
                  _this7.groupedData = lodash__WEBPACK_IMPORTED_MODULE_2__[
                    "groupBy"
                  ](_this7.data, "time");
                });
              },
            },
          ]);

          return SidebarComponent;
        })();

        SidebarComponent.ɵfac = function SidebarComponent_Factory(t) {
          return new (t || SidebarComponent)(
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](
              _app_home_quote_service__WEBPACK_IMPORTED_MODULE_1__[
                "QuoteService"
              ]
            )
          );
        };

        SidebarComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__[
          "ɵɵdefineComponent"
        ]({
          type: SidebarComponent,
          selectors: [["app-sidebar"]],
          decls: 68,
          vars: 9,
          consts: [
            [1, "container-fluid", "p-0", "text-dark"],
            [
              1,
              "row",
              "w-100",
              "m-0",
              "sideBarTitle",
              "d-flex",
              "align-content-center",
            ],
            [1, "col-12", "text-center"],
            [1, "font-weight-bold", "font26", "mt-2"],
            [
              "href",
              "https://github.com/nkoutroumanis/NoSQL-Operators",
              "target",
              "_blank",
              1,
              "pointerToClick",
            ],
            ["src", "assets/github.png", 1, "img-fluid", 2, "height", "1.3rem"],
            [1, "row", "w-100", "m-0", "mt-2", "p-2"],
            [1, "col-12"],
            [1, "font-weight-bold", 2, "font-size", "1.1rem"],
            [1, "col-12", "mt-3"],
            [1, "font-weight-bold"],
            [1, "col-12", "mt-5", "p-0"],
            [2, "display", "block"],
            ["baseChart", "", 3, "data", "labels", "chartType"],
            [
              "baseChart",
              "",
              3,
              "datasets",
              "labels",
              "options",
              "legend",
              "chartType",
            ],
          ],
          template: function SidebarComponent_Template(rf, ctx) {
            if (rf & 1) {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                0,
                "div",
                0
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                3,
                "div",
                1
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "\n    ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                5,
                "div",
                2
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                6,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                7,
                "p",
                3
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                8,
                "NoDa Spatial Visualization"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                9,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                10,
                "p"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                11,
                "NoSQL Spatial Data visualization tool"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                12,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                13,
                "a",
                4
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                14,
                "\n        "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](
                15,
                "img",
                5
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                16,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                17,
                "\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                19,
                "\n\n  "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](20, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                21,
                "div",
                6
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                22,
                "\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                23,
                "\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                24,
                "div",
                7
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                25,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                26,
                "p",
                8
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                27,
                "Data Analytics"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                28,
                "\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                29,
                "\n\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                30,
                "\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                31,
                "div",
                9
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                32,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                33,
                "p"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                34,
                "\n        "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                35,
                "span",
                10
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                36,
                "\n          Results:\n        "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](37);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                38,
                "\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                39,
                "\n\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                40,
                "\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                41,
                "div",
                11
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                42,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                43,
                "div"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                44,
                "\n        "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                45,
                "div",
                12
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                46,
                "\n          "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                47,
                "canvas",
                13
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                48,
                "\n          "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                49,
                "\n        "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                50,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                51,
                "\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                52,
                "\n\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                53,
                "\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                54,
                "div",
                11
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                55,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                56,
                "div"
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                57,
                "\n        "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                58,
                "div",
                12
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                59,
                "\n          "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](
                60,
                "canvas",
                14
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                61,
                "\n          "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                62,
                "\n        "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                63,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](
                64,
                "\n    "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](65, "\n  ");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](66, "\n");

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](67, "\n");
            }

            if (rf & 2) {
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](37);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](
                "\n        ",
                ctx.data.length,
                "\n      "
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](10);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
                "data",
                ctx.doughnutChartData
              )("labels", ctx.doughnutChartLabels)(
                "chartType",
                ctx.doughnutChartType
              );

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](13);

              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"](
                "datasets",
                ctx.barChartData
              )("labels", ctx.barChartLabels)("options", ctx.barChartOptions)(
                "legend",
                ctx.barChartLegend
              )("chartType", ctx.barChartType);
            }
          },
          directives: [
            ng2_charts__WEBPACK_IMPORTED_MODULE_3__["BaseChartDirective"],
          ],
          styles: [
            ".container-fluid[_ngcontent-%COMP%] {\n  box-shadow: 0 3px 10px 4px #eeeeee38;\n  height: 100vh;\n}\n\n.sideBarTitle[_ngcontent-%COMP%] {\n  height: 20vh;\n  padding-top: 1rem;\n  padding-bottom: 1rem;\n  border-bottom: 0.8px solid #222831;\n}\n\n.buttonsNav[_ngcontent-%COMP%] {\n  border-radius: 14px;\n  border: 0.8px solid #222831;\n  color: #222831;\n}\n\n.buttonsNav[_ngcontent-%COMP%]:hover {\n  border: 0.8px solid #222831;\n  background-color: #222831;\n  color: white;\n}\n\n.activeRoute[_ngcontent-%COMP%] {\n  border: 0.8px solid #222831;\n  background-color: #222831;\n  color: white;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi9Vc2Vycy9uaWtvc2tvdXMvTm9TUUwtT3BlcmF0b3JzL25vZGEtdmlzdWFsaXphdGlvbi9zcmMvbWFpbi91aS9zcmMvYXBwL3NoZWxsL3NpZGViYXIvc2lkZWJhci5jb21wb25lbnQuc2NzcyIsInNyYy9hcHAvc2hlbGwvc2lkZWJhci9zaWRlYmFyLmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usb0NBQUE7RUFDQSxhQUFBO0FDQ0Y7O0FERUE7RUFDRSxZQUFBO0VBQ0EsaUJBQUE7RUFDQSxvQkFBQTtFQUNBLGtDQUFBO0FDQ0Y7O0FERUE7RUFDRSxtQkFBQTtFQUNBLDJCQUFBO0VBQ0EsY0FBQTtBQ0NGOztBREVBO0VBQ0UsMkJBQUE7RUFDQSx5QkFBQTtFQUNBLFlBQUE7QUNDRjs7QURFQTtFQUNFLDJCQUFBO0VBQ0EseUJBQUE7RUFDQSxZQUFBO0FDQ0YiLCJmaWxlIjoic3JjL2FwcC9zaGVsbC9zaWRlYmFyL3NpZGViYXIuY29tcG9uZW50LnNjc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuY29udGFpbmVyLWZsdWlkIHtcbiAgYm94LXNoYWRvdzogMCAzcHggMTBweCA0cHggI2VlZWVlZTM4O1xuICBoZWlnaHQ6IDEwMHZoO1xufVxuXG4uc2lkZUJhclRpdGxlIHtcbiAgaGVpZ2h0OiAyMHZoO1xuICBwYWRkaW5nLXRvcDogMXJlbTtcbiAgcGFkZGluZy1ib3R0b206IDFyZW07XG4gIGJvcmRlci1ib3R0b206IDAuOHB4IHNvbGlkICMyMjI4MzE7XG59XG5cbi5idXR0b25zTmF2IHtcbiAgYm9yZGVyLXJhZGl1czogMTRweDtcbiAgYm9yZGVyOiAwLjhweCBzb2xpZCAjMjIyODMxO1xuICBjb2xvcjogIzIyMjgzMTtcbn1cblxuLmJ1dHRvbnNOYXY6aG92ZXIge1xuICBib3JkZXI6IDAuOHB4IHNvbGlkICMyMjI4MzE7XG4gIGJhY2tncm91bmQtY29sb3I6ICMyMjI4MzE7XG4gIGNvbG9yOiB3aGl0ZTtcbn1cblxuLmFjdGl2ZVJvdXRlIHtcbiAgYm9yZGVyOiAwLjhweCBzb2xpZCAjMjIyODMxO1xuICBiYWNrZ3JvdW5kLWNvbG9yOiAjMjIyODMxO1xuICBjb2xvcjogd2hpdGU7XG59XG4iLCIuY29udGFpbmVyLWZsdWlkIHtcbiAgYm94LXNoYWRvdzogMCAzcHggMTBweCA0cHggI2VlZWVlZTM4O1xuICBoZWlnaHQ6IDEwMHZoO1xufVxuXG4uc2lkZUJhclRpdGxlIHtcbiAgaGVpZ2h0OiAyMHZoO1xuICBwYWRkaW5nLXRvcDogMXJlbTtcbiAgcGFkZGluZy1ib3R0b206IDFyZW07XG4gIGJvcmRlci1ib3R0b206IDAuOHB4IHNvbGlkICMyMjI4MzE7XG59XG5cbi5idXR0b25zTmF2IHtcbiAgYm9yZGVyLXJhZGl1czogMTRweDtcbiAgYm9yZGVyOiAwLjhweCBzb2xpZCAjMjIyODMxO1xuICBjb2xvcjogIzIyMjgzMTtcbn1cblxuLmJ1dHRvbnNOYXY6aG92ZXIge1xuICBib3JkZXI6IDAuOHB4IHNvbGlkICMyMjI4MzE7XG4gIGJhY2tncm91bmQtY29sb3I6ICMyMjI4MzE7XG4gIGNvbG9yOiB3aGl0ZTtcbn1cblxuLmFjdGl2ZVJvdXRlIHtcbiAgYm9yZGVyOiAwLjhweCBzb2xpZCAjMjIyODMxO1xuICBiYWNrZ3JvdW5kLWNvbG9yOiAjMjIyODMxO1xuICBjb2xvcjogd2hpdGU7XG59Il19 */",
          ],
        });
        /*@__PURE__*/

        (function () {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](
            SidebarComponent,
            [
              {
                type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
                args: [
                  {
                    selector: "app-sidebar",
                    templateUrl: "./sidebar.component.html",
                    styleUrls: ["./sidebar.component.scss"],
                  },
                ],
              },
            ],
            function () {
              return [
                {
                  type:
                    _app_home_quote_service__WEBPACK_IMPORTED_MODULE_1__[
                      "QuoteService"
                    ],
                },
              ];
            },
            null
          );
        })();
        /***/
      },

    /***/
    "./src/environments/.env.ts":
      /*!**********************************!*\
    !*** ./src/environments/.env.ts ***!
    \**********************************/

      /*! exports provided: env */

      /***/
      function srcEnvironmentsEnvTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "env", function () {
          return env;
        });

        var env = {
          npm_package_version: "1.0.0",
        };
        /***/
      },

    /***/
    "./src/environments/environment.ts":
      /*!*****************************************!*\
    !*** ./src/environments/environment.ts ***!
    \*****************************************/

      /*! exports provided: environment */

      /***/
      function srcEnvironmentsEnvironmentTs(
        module,
        __webpack_exports__,
        __webpack_require__
      ) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "environment", function () {
          return environment;
        });
        /* harmony import */

        var _env__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! ./.env */
          "./src/environments/.env.ts"
        ); // This file can be replaced during build by using the `fileReplacements` array.
        // `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
        // The list of file replacements can be found in `angular.json`.
        // `.env.ts` is generated by the `npm run env` command
        // `npm run env` exposes environment variables as JSON for any usage you might
        // want, like displaying the version or getting extra config from your CI bot, etc.
        // This is useful for granularity you might need beyond just the environment.
        // Note that as usual, any environment variables you expose through it will end up in your
        // bundle, and you should not use it for any sensitive information like passwords or keys.

        var environment = {
          production: false,
          hmr: false,
          version:
            _env__WEBPACK_IMPORTED_MODULE_0__["env"].npm_package_version +
            "-dev",
          serverUrl: "http://localhost:8080",
          defaultLanguage: "en-US",
          supportedLanguages: ["en-US"],
        };
        /*
         * For easier debugging in development mode, you can import the following file
         * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
         *
         * This import should be commented out in production mode because it will have a negative impact
         * on performance if an error is thrown.
         */
        // import 'zone.js/dist/zone-error';  // Included with Angular CLI.

        /***/
      },

    /***/
    "./src/hmr.ts":
      /*!********************!*\
    !*** ./src/hmr.ts ***!
    \********************/

      /*! exports provided: hmrBootstrap */

      /***/
      function srcHmrTs(module, __webpack_exports__, __webpack_require__) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* harmony export (binding) */

        __webpack_require__.d(__webpack_exports__, "hmrBootstrap", function () {
          return hmrBootstrap;
        });
        /* harmony import */

        var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
          /*! @angular/core */
          "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
        );
        /* harmony import */

        var _angularclass_hmr__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
          /*! @angularclass/hmr */
          "./node_modules/@angularclass/hmr/dist/index.js"
        );
        /* harmony import */

        var _angularclass_hmr__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/ __webpack_require__.n(
          _angularclass_hmr__WEBPACK_IMPORTED_MODULE_1__
        );

        function hmrBootstrap(module, bootstrap) {
          var ngModule;
          module.hot.accept();
          bootstrap()
            .then(function (mod) {
              return (ngModule = mod);
            })
            ["catch"](function (err) {
              return console.error(err);
            });
          module.hot.dispose(function () {
            var appRef = ngModule.injector.get(
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["ApplicationRef"]
            );
            var elements = appRef.components.map(function (c) {
              return c.location.nativeElement;
            });
            var makeVisible = Object(
              _angularclass_hmr__WEBPACK_IMPORTED_MODULE_1__["createNewHosts"]
            )(elements);
            ngModule.destroy();
            makeVisible();
          });
        }
        /***/
      },

    /***/
    "./src/main.ts":
      /*!*********************!*\
    !*** ./src/main.ts ***!
    \*********************/

      /*! no exports provided */

      /***/
      function srcMainTs(module, __webpack_exports__, __webpack_require__) {
        "use strict";

        __webpack_require__.r(__webpack_exports__);
        /* WEBPACK VAR INJECTION */

        (function (module) {
          /* harmony import */
          var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
            /*! @angular/core */
            "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js"
          );
          /* harmony import */

          var _env_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
            /*! @env/environment */
            "./src/environments/environment.ts"
          );
          /* harmony import */

          var _hmr__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
            /*! ./hmr */
            "./src/hmr.ts"
          );
          /* harmony import */

          var _app_app_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
            /*! ./app/app.module */
            "./src/app/app.module.ts"
          );
          /* harmony import */

          var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
            /*! @angular/platform-browser */
            "./node_modules/@angular/platform-browser/__ivy_ngcc__/fesm2015/platform-browser.js"
          );
          /*
           * Entry point of the application.
           * Only platform bootstrapping code should be here.
           * For app-specific initialization, use `app/app.component.ts`.
           */

          if (
            _env_environment__WEBPACK_IMPORTED_MODULE_1__["environment"]
              .production
          ) {
            Object(
              _angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"]
            )();
          }

          var bootstrap = function bootstrap() {
            return _angular_platform_browser__WEBPACK_IMPORTED_MODULE_4__[
              "platformBrowser"
            ]().bootstrapModule(
              _app_app_module__WEBPACK_IMPORTED_MODULE_3__["AppModule"]
            );
          };

          if (
            _env_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].hmr
          ) {
            Object(_hmr__WEBPACK_IMPORTED_MODULE_2__["hmrBootstrap"])(
              module,
              bootstrap
            );
          } else {
            bootstrap()["catch"](function (err) {
              return console.error(err);
            });
          }
          /* WEBPACK VAR INJECTION */
        }.call(
          this,
          __webpack_require__(
            /*! ./../node_modules/webpack/buildin/harmony-module.js */
            "./node_modules/webpack/buildin/harmony-module.js"
          )(module)
        ));
        /***/
      },

    /***/
    "./src/translations/en-US.json":
      /*!*************************************!*\
    !*** ./src/translations/en-US.json ***!
    \*************************************/

      /*! exports provided: APP_NAME, About, Hello world !, Home, Version, default */

      /***/
      function srcTranslationsEnUSJson(module) {
        module.exports = JSON.parse(
          '{"APP_NAME":"Noda Visualization","About":"About","Hello world !":"Hello world !","Home":"Home","Version":"Version"}'
        );
        /***/
      },

    /***/
    0:
      /*!***************************!*\
    !*** multi ./src/main.ts ***!
    \***************************/

      /*! no static exports found */

      /***/
      function _(module, exports, __webpack_require__) {
        module.exports = __webpack_require__(
          /*! /Users/nikoskous/NoSQL-Operators/noda-visualization/src/main/ui/src/main.ts */
          "./src/main.ts"
        );
        /***/
      },
  },
  [[0, "runtime", "vendor"]],
]);
//# sourceMappingURL=main-es5.js.map
