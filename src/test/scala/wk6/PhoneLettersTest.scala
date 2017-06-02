package wk6

import org.scalatest.{Matchers, path}

class PhoneLettersTest extends path.FunSpec with Matchers {

  describe("phone mnemonics") {

    it("reads words from URL") {
      new PhoneLetters().first(10) shouldBe("foo")
    }
  }

}
