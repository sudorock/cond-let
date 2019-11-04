(ns cond-let.core)

(defmacro cond-let
  ([] nil)
  ([cnd-bnd exp & rmn] (if (vector? cnd-bnd)
                         (let [form (cnd-bnd 0) tst (cnd-bnd 1)]
                           `(let [tmp# ~tst]
                              (if tmp#
                                (let [~form tmp#] ~exp)
                                (cond-let ~@rmn))))
                         `(if ~cnd-bnd ~exp (cond-let ~@rmn)))))
