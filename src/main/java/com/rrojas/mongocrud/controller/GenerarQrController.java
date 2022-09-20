package com.rrojas.mongocrud.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.rrojas.mongocrud.model.GenerarQr;


@RestController
@RequestMapping("/api")
public class GenerarQrController {

	@PostMapping("/generarQr")
	public Map<String, Object> newQr(@RequestBody GenerarQr qr) throws WriterException, IOException {
		HashMap<String, Object> map = new HashMap<>();

		map.put("QR", generarQR(qr));
		map.put("STATUS", HttpStatus.OK);
		return map;
	}

	private String generarQR(GenerarQr qr) throws WriterException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BitMatrix bitMatrix = new MultiFormatWriter().encode("Total:" + qr.getTotal(), BarcodeFormat.QR_CODE, 250, 250);

		MatrixToImageWriter.writeToStream(bitMatrix,MediaType.IMAGE_PNG.getSubtype(), baos, new MatrixToImageConfig());
		byte[] data = baos.toByteArray();
		String encodeString = Base64.getEncoder().encodeToString(data);
		return encodeString;
	}
}
