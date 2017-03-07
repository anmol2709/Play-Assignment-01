package services

object MD5 {
  def hash(password: String) = {
    val m = java.security.MessageDigest.getInstance("MD5")
    val b = password.getBytes("UTF-8")
    m.update(b, 0, b.length)
    new java.math.BigInteger(1, m.digest()).toString(16)
  }
}