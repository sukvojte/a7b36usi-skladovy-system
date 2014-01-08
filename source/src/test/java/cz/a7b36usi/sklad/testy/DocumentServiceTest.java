/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.a7b36usi.sklad.testy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cz.a7b36usi.sklad.BO.DocumentType;
import cz.a7b36usi.sklad.DTO.CategoryDTO;
import cz.a7b36usi.sklad.DTO.DocumentDTO;
import cz.a7b36usi.sklad.DTO.MovementDTO;
import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;
import cz.a7b36usi.sklad.Service.IDocumentService;
import cz.a7b36usi.sklad.Service.IOrderService;
import cz.a7b36usi.sklad.Service.IPartnerService;
import cz.a7b36usi.sklad.Service.IProductService;

public class DocumentServiceTest extends AbstractServiceTest {
	@Autowired
	IOrderService orderService;

	@Autowired
	IDocumentService documentService;

	@Autowired
	IPartnerService partnerService;

	@Autowired
	IProductService productService;

	@Test
	public void saveDocument() {
		PartnerDTO partId = addPartner();
		Date d = new Date();
		DocumentDTO doc = new DocumentDTO(null, DocumentType.VYDEJKA, partId,
				5, d);
		Long docId = documentService.saveDocument(doc);
		assertNotNull(docId);
		List<DocumentDTO> docList = documentService.getAllDocuments();
		boolean objDetected = false;
		for (int i = 0; i < docList.size(); i++) {
			if (docList.get(i).getId().equals(docId)) {
				objDetected = true;
				assertEquals(DocumentType.VYDEJKA, docList.get(i)
						.getDocumentType());
				assertEquals(partId.getId(), docList.get(i).getPartner()
						.getId());
				assertEquals(5, docList.get(i).getNumber());
				assertEquals(d, docList.get(i).getDate());
			}
		}
		assertTrue(objDetected);
	}

	@Test
	public void saveMovement() {
		PartnerDTO partId = addPartner();
		Date d = new Date();
		DocumentDTO doc = new DocumentDTO(null, DocumentType.VYDEJKA, partId,
				5, d);
		Long docId = documentService.saveDocument(doc);
		doc.setId(docId);
		ProductDTO prod = addProduct(addCategory().getId());
		Long wrap = addWrap(prod.getId());
		Long vers = addVersion(prod.getId());
		MovementDTO mov = new MovementDTO(null, 21.0, wrap, vers, prod, doc, 0);
		Long movId = documentService.saveMovement(mov);
		assertNotNull(movId);
		List<MovementDTO> movList = documentService.getAllMovements();
		boolean objDetected = false;
		for (int i = 0; i < movList.size(); i++) {
			if (movList.get(i).getId().equals(movId)) {
				objDetected = true;
				assertTrue(21.0 == movList.get(i).getPrice());//TODO: upravit
				 assertEquals(wrap,movList.get(i).getWrapping());
				 assertEquals(vers,movList.get(i).getVersion());
				assertEquals(prod.getId(), movList.get(i).getProdukt().getId());
				assertEquals(docId, movList.get(i).getDocument().getId());
			}
		}
		assertTrue(objDetected);
	}

	@Test
	public void removeDocument() {
		PartnerDTO partId = addPartner();
		Date d = new Date();
		DocumentDTO doc = new DocumentDTO(null, DocumentType.VYDEJKA, partId,
				5, d);
		Long docId = documentService.saveDocument(doc);
		documentService.removeDocument(docId);
		List<DocumentDTO> docList = documentService.getAllDocuments();
		boolean objNotDetected = true;
		for (int i = 0; i < docList.size(); i++) {
			if (docList.get(i).getId().equals(docId)) {
				objNotDetected = false;
			}
		}
		assertTrue(objNotDetected);
	}

	@Test
	public void removeMovement() {
		PartnerDTO partId = addPartner();
		Date d = new Date();
		DocumentDTO doc = new DocumentDTO(null, DocumentType.VYDEJKA, partId,
				5, d);
		documentService.saveDocument(doc);
		doc = documentService.getAllDocuments().get(0);
		ProductDTO prod = addProduct(addCategory().getId());
		Long wrap = addWrap(prod.getId());
		Long vers = addVersion(prod.getId());
		MovementDTO mov = new MovementDTO(null, 21.0, wrap, vers, prod, doc, 0);
		Long movId = documentService.saveMovement(mov);
		documentService.removeMovement(movId);
		List<MovementDTO> movList = documentService.getAllMovements();
		boolean objNotDetected = true;
		for (int i = 0; i < movList.size(); i++) {
			if (movList.get(i).getId().equals(movId)) {
				objNotDetected = false;
			}
		}
		assertTrue(objNotDetected);
	}

	@Test
	public void getAllDocuments() {
		Date d = new Date();
		PartnerDTO partId = addPartner();
		DocumentDTO doc = new DocumentDTO(null, DocumentType.VYDEJKA, partId,
				5, d);
		Long docId = documentService.saveDocument(doc);
		Date d2 = new Date();
		PartnerDTO partId2 = addPartner();
		DocumentDTO doc2 = new DocumentDTO(null, DocumentType.PRIJEMKA,
				partId2, 15, d2);
		Long docId2 = documentService.saveDocument(doc2);
		List<DocumentDTO> docList = documentService.getAllDocuments();
		for (int i = 0; i < docList.size(); i++) {
			if (docList.get(i).getId().equals(docId)) {
				assertEquals(DocumentType.VYDEJKA, docList.get(i)
						.getDocumentType());
				assertEquals(partId.getId(), docList.get(i).getPartner()
						.getId());
				assertEquals(5, docList.get(i).getNumber());
				assertEquals(d, docList.get(i).getDate());
			} else if (docList.get(i).getId().equals(docId2)) {
				assertEquals(DocumentType.PRIJEMKA, docList.get(i)
						.getDocumentType());
				assertEquals(partId2.getId(), docList.get(i).getPartner()
						.getId());
				assertEquals(15, docList.get(i).getNumber());
				assertEquals(d2, docList.get(i).getDate());
			}

		}

	}

	 @Test
	public void getAllMovements() {
		PartnerDTO partId = addPartner();
		Date d = new Date();
		DocumentDTO doc = new DocumentDTO(null, DocumentType.VYDEJKA, partId,
				5, d);
		Long docId = documentService.saveDocument(doc);
		ProductDTO prod = addProduct(addCategory().getId());
		Long wrap = addWrap(prod.getId());
		Long vers = addVersion(prod.getId());
		doc.setId(docId);
		MovementDTO mov = new MovementDTO(null, 21.0, wrap, vers, prod, doc, 0);
		MovementDTO mov2 = new MovementDTO(null, 22.0, wrap, vers, prod, doc, 0);
		Long mov1Id = documentService.saveMovement(mov);
		Long mov2Id = documentService.saveMovement(mov2);
		List<MovementDTO> movList = documentService.getAllMovements();

		assertEquals(mov1Id, movList.get(0).getId());
		 assertTrue(21.0==movList.get(0).getPrice());
		 assertEquals(wrap,movList.get(0).getWrapping());
		 assertEquals(vers,movList.get(0).getVersion());
		assertEquals(prod.getId(), movList.get(0).getProdukt().getId());
		assertEquals(docId, movList.get(0).getDocument().getId());

		assertEquals(mov2Id, movList.get(1).getId());
		 assertTrue(22.0==movList.get(1).getPrice());
		 assertEquals(wrap,movList.get(1).getWrapping());
		 assertEquals(vers,movList.get(1).getVersion());
		assertEquals(prod.getId(), movList.get(1).getProdukt().getId());
		assertEquals(docId, movList.get(1).getDocument().getId());
	}

	@Test
	public void getAllDocumentsMovements() {
		PartnerDTO partId = addPartner();
		Date d = new Date();
		DocumentDTO doc = new DocumentDTO(null, DocumentType.VYDEJKA, partId,
				5, d);
		Long docId = documentService.saveDocument(doc);
		ProductDTO prod = addProduct(addCategory().getId());
		Long wrap = addWrap(prod.getId());
		Long vers = addVersion(prod.getId());
		doc.setId(docId);
		MovementDTO mov = new MovementDTO(null, 21.0, wrap, vers, prod, doc, 0);
		Long movId = documentService.saveMovement(mov);
		List<MovementDTO> movList = documentService
				.getAllDocumentsMovements(docId);
		assertEquals(1, movList.size());

		assertEquals(movId, movList.get(0).getId());
		assertTrue(21.0 == movList.get(0).getPrice());
		 assertEquals(wrap,movList.get(0).getWrapping());
		 assertEquals(vers,movList.get(0).getVersion());
		assertEquals(prod.getId(), movList.get(0).getProdukt().getId());
		assertEquals(docId, movList.get(0).getDocument().getId());
	}

	@Test
	public void getAllPartnersDocuments() {
		PartnerDTO partId = addPartner();
		Date d = new Date();
		DocumentDTO doc = new DocumentDTO(null, DocumentType.VYDEJKA, partId,
				5, d);
		Long docId = documentService.saveDocument(doc);
		ProductDTO prod = addProduct(addCategory().getId());
		Long wrap = addWrap(prod.getId());
		Long vers = addVersion(prod.getId());
		doc = documentService.getAllDocuments().get(0);
		MovementDTO mov = new MovementDTO(null, 21.0, wrap, vers, prod, doc, 0);
		documentService.saveMovement(mov);
		List<DocumentDTO> docList = documentService
				.getAllPartnersDocuments(partId.getId());
		assertEquals(1, docList.size());
		assertEquals(docId, docList.get(0).getId());
		assertEquals(DocumentType.VYDEJKA, docList.get(0).getDocumentType());
		assertEquals(partId.getId(), docList.get(0).getPartner().getId());
		assertEquals(5, docList.get(0).getNumber());
		assertEquals(d, docList.get(0).getDate());
	}

	@Test
	public void getAllProductsMovements() {
		PartnerDTO partId = addPartner();
		Date d = new Date();
		DocumentDTO doc = new DocumentDTO(null, DocumentType.VYDEJKA, partId,
				5, d);
		Long docId = documentService.saveDocument(doc);
		ProductDTO prod = addProduct(addCategory().getId());
		Long wrap = addWrap(prod.getId());
		Long vers = addVersion(prod.getId());
		doc.setId(docId);
		MovementDTO mov = new MovementDTO(null, 21.0, wrap, vers, prod, doc, 0);
		Long movId = documentService.saveMovement(mov);
		List<MovementDTO> movList = documentService
				.getAllProductsMovements(prod.getId());
		assertEquals(1, movList.size());

		assertEquals(movId, movList.get(0).getId());
		assertTrue(21.0 == movList.get(0).getPrice());
		 assertEquals(wrap,movList.get(0).getWrapping());
		 assertEquals(vers,movList.get(0).getVersion());
		assertEquals(prod.getId(), movList.get(0).getProdukt().getId());
		assertEquals(docId, movList.get(0).getDocument().getId());
	}

	public PartnerDTO addPartner() {
		boolean isDod = true;
		boolean isOdb = false;
		String street = "ULICE";
		String mesto = "mesto" + System.currentTimeMillis();
		String spolecnost = "BLA BLA" + System.currentTimeMillis();
		int psc = 90324;
		int cisloPop = 43551553;

		Long id = partnerService.addPartner(isDod, isOdb, street, mesto,
				spolecnost, psc, cisloPop);
		List<PartnerDTO> list = partnerService.getAllPartners();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				return list.get(i);
			}

		}
		return null;
	}

	public Long addWrap(Long productId) {
		WrappingTypeDTO wrp = new WrappingTypeDTO(null, "box", 30.0, productId);
		return productService.saveWrappingType(wrp);
	}

	public ProductDTO addProduct(Long catId) {
		ProductDTO pr = new ProductDTO(null, "kase", "FGSVRI",
				Integer.valueOf(12), catId);
		Long prodId = productService.saveProduct(pr);
		List<ProductDTO> list = productService.getAllProducts();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(prodId)) {
				return list.get(i);
			}

		}
		return null;
	}

	public CategoryDTO addCategory() {
		CategoryDTO cat = new CategoryDTO(null, "jidlo", null);
		Long catId = productService.saveCategory(cat);
		List<CategoryDTO> list = productService.getAllCategories();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(catId)) {
				return list.get(i);
			}

		}
		return null;
	}

	public Long addVersion(Long productId) {
		ProductVersionDTO prV = new ProductVersionDTO(null, Long.valueOf(1434),
				"verze 1", productId);
		return productService.saveProductVersion(prV);
	}
}
